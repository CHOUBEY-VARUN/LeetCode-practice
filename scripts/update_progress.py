#!/usr/bin/env python3
"""Update the repository's LeetCode progress section from the public profile."""

from datetime import datetime, timezone
import json
from pathlib import Path
import re
import sys
from urllib.error import HTTPError, URLError
from urllib.request import Request, urlopen

ROOT = Path(__file__).resolve().parent.parent
README = ROOT / "README.md"
USERNAME = "VarunCode21"
GRAPHQL_URL = "https://leetcode.com/graphql"
PROFILE_URL = f"https://leetcode.com/u/{USERNAME}/"
REPOSITORY_URL = "https://github.com/CHOUBEY-VARUN/LeetCode-practice"
START = "<!-- LEETCODE_PROGRESS_START -->"
END = "<!-- LEETCODE_PROGRESS_END -->"
TIMEOUT_SECONDS = 20

QUERY = """
query userProblemsSolved($username: String!) {
  matchedUser(username: $username) {
    submitStats {
      acSubmissionNum {
        difficulty
        count
      }
    }
  }
}
"""


class ProgressFetchError(Exception):
    """Raised when the public profile cannot provide a reliable solved count."""


def fetch_profile_solved_count():
    payload = json.dumps(
        {"query": QUERY, "variables": {"username": USERNAME}}
    ).encode("utf-8")
    request = Request(
        GRAPHQL_URL,
        data=payload,
        headers={
            "Content-Type": "application/json",
            "User-Agent": "LeetCode-Progress-Tracker/1.0 (GitHub Actions)",
            "Referer": PROFILE_URL,
        },
        method="POST",
    )

    try:
        with urlopen(request, timeout=TIMEOUT_SECONDS) as response:
            if response.status < 200 or response.status >= 300:
                raise ProgressFetchError(
                    f"LeetCode returned HTTP status {response.status}."
                )
            data = json.loads(response.read().decode("utf-8"))
    except HTTPError as error:
        raise ProgressFetchError(f"LeetCode returned HTTP {error.code}.") from error
    except (URLError, TimeoutError, OSError) as error:
        raise ProgressFetchError(f"Could not reach LeetCode: {error}") from error
    except (UnicodeDecodeError, json.JSONDecodeError) as error:
        raise ProgressFetchError("LeetCode returned invalid JSON.") from error

    if not isinstance(data, dict):
        raise ProgressFetchError("LeetCode returned an unexpected response.")
    if data.get("errors"):
        raise ProgressFetchError("LeetCode GraphQL returned an error.")

    matched_user = (data.get("data") or {}).get("matchedUser")
    if not isinstance(matched_user, dict):
        raise ProgressFetchError(f"LeetCode profile '{USERNAME}' was not found.")

    submissions = (
        (matched_user.get("submitStats") or {}).get("acSubmissionNum")
    )
    if not isinstance(submissions, list):
        raise ProgressFetchError("LeetCode solved-count data is missing.")

    for entry in submissions:
        if isinstance(entry, dict) and entry.get("difficulty") == "All":
            count = entry.get("count")
            if isinstance(count, int) and not isinstance(count, bool) and count >= 0:
                return count
            raise ProgressFetchError("LeetCode's total solved count is invalid.")

    raise ProgressFetchError("LeetCode's total solved count is missing.")


def count_documented_problems():
    """Count distinct numbered problem IDs with at least one Java source file."""
    folder_pattern = re.compile(r"^(\d+)-.+$")
    problem_ids = set()

    for folder in ROOT.iterdir():
        match = folder_pattern.match(folder.name)
        if folder.is_dir() and match and any(folder.glob("*.java")):
            problem_ids.add(int(match.group(1)))

    return len(problem_ids)


def render_section(profile_count, repository_count, updated_at):
    return f"""\n## LeetCode Progress

| Metric | Count | Meaning |
| --- | ---: | --- |
| [LeetCode profile]({PROFILE_URL}) | {profile_count} | Total solved on my public LeetCode profile |
| [Documented in this repository]({REPOSITORY_URL}) | {repository_count} | Problems with committed Java solutions |

Last successful update: {updated_at} (UTC)
"""


def update_readme(profile_count, repository_count):
    readme = README.read_text(encoding="utf-8")
    if readme.count(START) != 1 or readme.count(END) != 1:
        raise ValueError("README progress markers are missing or duplicated.")

    start = readme.index(START) + len(START)
    end = readme.index(END)
    if end < start:
        raise ValueError("README progress markers are out of order.")

    updated_at = datetime.now(timezone.utc).strftime("%Y-%m-%d %H:%M:%S")
    updated = readme[:start] + render_section(
        profile_count, repository_count, updated_at
    ) + readme[end:]

    if updated != readme:
        README.write_text(updated, encoding="utf-8")
        print("README progress section updated.")
    else:
        print("README progress section already up to date.")


def main():
    repository_count = count_documented_problems()
    print(f"Documented repository problems: {repository_count}")

    try:
        profile_count = fetch_profile_solved_count()
    except ProgressFetchError as error:
        # Do not touch the README: its last known-good profile value and timestamp
        # are more trustworthy than a failed/partial response.
        print(f"Unable to refresh LeetCode profile count: {error}", file=sys.stderr)
        return 1

    print(f"LeetCode profile problems solved: {profile_count}")
    update_readme(profile_count, repository_count)
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
