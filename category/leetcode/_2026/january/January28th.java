package category.leetcode._2026.january;

import java.util.Arrays;

public class January28th {

    public int minCost(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int inf = Integer.MAX_VALUE / 4;
        int[][] cost = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], inf);
        }

        cost[n - 1][m - 1] = 0;
        int maxVal = 0;

        for (int[] row : grid) {
            for (int v : row) {
                maxVal = Math.max(maxVal, v);
            }
        }

        int[] tCost = new int[maxVal + 1];

        for (int t = 0; t <= k; t++) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (i < n - 1) {
                        cost[i][j] = Math.min(cost[i][j], cost[i + 1][j] + grid[i + 1][j]);
                    }

                    if (j < m - 1) {
                        cost[i][j] = Math.min(cost[i][j], cost[i][j + 1] + grid[i][j + 1]);
                    }

                    if (t > 0) {
                        cost[i][j] = Math.min(cost[i][j], tCost[grid[i][j]]);
                    }
                }
            }

            Arrays.fill(tCost, inf);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int v = grid[i][j];
                    tCost[v] = Math.min(tCost[v], cost[i][j]);
                }
            }

            for (int i = 1; i < tCost.length; i++) {
                tCost[i] = Math.min(tCost[i], tCost[i - 1]);
            }
        }

        return cost[0][0];
    }
}
