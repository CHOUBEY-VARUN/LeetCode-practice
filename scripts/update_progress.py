
import json
import re
import sys
from datetime import datetime, timezone
from pathlib import Path
from urllib.request import Request, urlopen
from urllib.error import HTTPError, URLError

# Repository configuration
ROOT = Path(__file__).resolve().parent.parent
README = ROOT / "README.md"

LEETCODE_USERNAME = "VarunCode21"

START_MARKER = "<!-- LEETCODE_PROGRESS_START -->"
END_MARKER = "<!-- LEETCODE_PROGRESS_END -->"


def fetch_leetcode_total():
    """Fetch the total number of solved problems from LeetCode."""

    query = """
    query userProgress($username: String!) {
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

    variables = {
        "username": LEETCODE_USERNAME
    }

    payload = {
        "query": query,
        "variables": variables
    }

    request = Request(
        "https://leetcode.com/graphql",
        data=json.dumps(payload).encode("utf-8"),
        headers={
            "Content-Type": "application/json",
            "User-Agent": "Mozilla/5.0",
            "Referer": f"https://leetcode.com/{LEETCODE_USERNAME}/"
        },
        method="POST"
    )

    try:
        with urlopen(request, timeout=30) as response:
            data = json.loads(response.read().decode("utf-8"))

        user = data.get("data", {}).get("matchedUser")

        if not user:
            raise RuntimeError("LeetCode profile was not found.")

        counts = user["submitStats"]["acSubmissionNum"]

        for item in counts:
            if item["difficulty"] == "All":
                return item["count"]

        raise RuntimeError("Total solved count was missing.")

    except (HTTPError, URLError, TimeoutError, json.JSONDecodeError) as error:
        raise RuntimeError(
            f"Could not fetch LeetCode progress: {error}"
        ) from error


def count_documented_solutions():
    """Count problem folders containing at least one Java file."""

    count = 0

    for folder in ROOT.iterdir():

        if not folder.is_dir():
            continue

        if not re.match(r"^\d{1,5}-.+", folder.name):
            continue

        java_files = list(folder.glob("*.java"))

        if java_files:
            count += 1

    return count


def update_readme(leetcode_total, documented_total):
    """Replace only the progress section in README.md."""

    readme = README.read_text(encoding="utf-8")

    if readme.count(START_MARKER) != 1:
        raise RuntimeError("Start marker missing or duplicated.")

    if readme.count(END_MARKER) != 1:
        raise RuntimeError("End marker missing or duplicated.")

    updated_at = datetime.now(timezone.utc).strftime(
        "%Y-%m-%d %H:%M UTC"
    )

    new_section = f"""<!-- LEETCODE_PROGRESS_START -->
## LeetCode Progress

| Metric | Count | Meaning |
| --- | ---: | --- |
| **LeetCode profile** | **{leetcode_total}** | Total solved problems on [my LeetCode profile](https://leetcode.com/u/{LEETCODE_USERNAME}/). |
| **Documented solutions** | **{documented_total}** | Problems with a committed Java solution in this repository. |

*Last updated: {updated_at}*

[View all documented solutions](https://github.com/CHOUBEY-VARUN/LeetCode-practice)

<!-- LEETCODE_PROGRESS_END -->"""

    pattern = (
        re.escape(START_MARKER)
        + r".*?"
        + re.escape(END_MARKER)
    )

    updated_readme = re.sub(
        pattern,
        lambda _: new_section,
        readme,
        count=1,
        flags=re.DOTALL
    )

    README.write_text(updated_readme, encoding="utf-8")


def main():
    print("Fetching LeetCode profile progress...")

    leetcode_total = fetch_leetcode_total()

    print("Counting documented Java solutions...")

    documented_total = count_documented_solutions()

    print(f"LeetCode profile: {leetcode_total}")
    print(f"Documented solutions: {documented_total}")

    update_readme(leetcode_total, documented_total)

    print("README.md updated successfully!")


if __name__ == "__main__":
    try:
        main()
    except Exception as error:
        print(f"ERROR: {error}", file=sys.stderr)
        sys.exit(1)
