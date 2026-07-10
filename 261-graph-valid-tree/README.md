# Graph Valid Tree

**Difficulty:** Medium

## Problem Statement

Given `n` nodes labeled from `0` to `n - 1` and a list of undirected edges, write a function to determine whether these edges form a valid tree.

A valid tree must satisfy two conditions:

1. The graph must be fully connected.
2. The graph must not contain any cycle.

## Examples

### Example 1

```text
Input:
n = 5
edges = [[0, 1], [0, 2], [0, 3], [1, 4]]

Output:
true
```

### Example 2

```text
Input:
n = 5
edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]

Output:
false
```

## Notes

* There are no duplicate edges.
* Since the graph is undirected, `[0, 1]` is the same as `[1, 0]`.
* Therefore, both `[0, 1]` and `[1, 0]` will not appear together.

## Constraints

```text
1 <= n <= 100
0 <= edges.length <= n * (n - 1) / 2
```
