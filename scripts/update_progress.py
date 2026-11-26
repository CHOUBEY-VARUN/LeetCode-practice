
from pathlib import Path
import re

ROOT = Path(__file__).resolve().parent.parent
README = ROOT / "README.md"

START = "<!-- LEETCODE_PROGRESS_START -->"
END = "<!-- LEETCODE_PROGRESS_END -->"

def count_solved_problems():
    problem_pattern = re.compile(r"^\d{4,}-.+")

    return sum(
        1
        for folder in ROOT.iterdir()
        if folder.is_dir()
        and problem_pattern.match(folder.name)
        and any(folder.glob("*.java"))
    )

def update_readme():
    count = count_solved_problems()
    readme = README.read_text(encoding="utf-8")

    if readme.count(START) != 1 or readme.count(END) != 1:
        raise ValueError("README progress markers are missing or duplicated.")

    section = f"""## LeetCode Progress

**{count} problems solved** and counting.

[View all solutions](https://github.com/CHOUBEY-VARUN/LeetCode-practice)

"""

    start = readme.index(START) + len(START)
    end = readme.index(END)

    updated = readme[:start] + "\n" + section + readme[end:]

    if updated != readme:
        README.write_text(updated, encoding="utf-8")
        print(f"README updated: {count} problems")
    else:
        print(f"README already up to date: {count} problems")

if __name__ == "__main__":
    update_readme()
