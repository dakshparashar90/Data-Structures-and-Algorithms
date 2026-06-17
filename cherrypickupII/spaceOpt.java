// Space Optimization

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] front = new int[m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {

                if (j1 == j2) {
                    front[j1][j2] = grid[n - 1][j1];
                } else {
                    front[j1][j2] =
                            grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {

            int[][] curr = new int[m][m];

            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = (int) -1e8;

                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {

                            int nj1 = j1 + d1;
                            int nj2 = j2 + d2;

                            if (nj1 < 0 || nj2 < 0 || nj1 >= m || nj2 >= m) {
                                continue;
                            }

                            maxi = Math.max(maxi, front[nj1][nj2]);
                        }
                    }

                    int val;
                    if (j1 == j2) {
                        val = grid[i][j1];
                    } else {
                        val = grid[i][j1] + grid[i][j2];
                    }

                    curr[j1][j2] = val + maxi;
                }
            }

            front = curr;
        }

        return front[0][m - 1];
    }
}