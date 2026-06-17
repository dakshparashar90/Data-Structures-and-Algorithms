# Cherry Pickup II - Dynamic Programming (3D DP)

## Problem

Two robots start from the first row of a grid:

* Robot 1 starts at `(0,0)`
* Robot 2 starts at `(0,m-1)`

Both robots move towards the last row. From any cell, a robot can move to:

* Down Left `(j - 1)`
* Down `(j)`
* Down Right `(j + 1)`

The objective is to collect the maximum number of cherries.

If both robots land on the same cell, the cherries from that cell are counted only once.

---

## Intuition

At any point, the future outcome depends on:

1. Current row
2. Column of Robot 1
3. Column of Robot 2

Therefore, the DP state becomes:

`dp[row][j1][j2]`

where:

* `row` = current row
* `j1` = position of Robot 1
* `j2` = position of Robot 2

For each state, both robots have 3 possible moves, resulting in:

`3 × 3 = 9 transitions`

We try all possible combinations and choose the maximum cherries collected.

---

## Approaches Implemented

### 1. Memoization (Top-Down DP)

* Recursive solution with caching.
* Avoids recalculating overlapping states.

Time Complexity: `O(N × M × M × 9)`

Space Complexity: `O(N × M × M) + O(N)` (recursion stack)

---

### 2. Tabulation (Bottom-Up DP)

* Builds the solution from the last row upwards.
* Eliminates recursion overhead.

Time Complexity: `O(N × M × M × 9)`

Space Complexity: `O(N × M × M)`

---

### 3. Space Optimized DP

Observation:
The current row only depends on the next row.

Instead of storing all rows, we keep:

* `front[][]` → next row
* `curr[][]` → current row

Time Complexity: `O(N × M × M × 9)`

Space Complexity: `O(M × M)`

---

## Key Learning

This problem is a great example of:

* 3D Dynamic Programming
* Multi-agent state representation
* State transitions
* DP optimization techniques

The most important takeaway was learning how to convert:

Recursion → Memoization → Tabulation → Space Optimization

while keeping the same state definition throughout the solution.
