package category.leetcode._2026.april;

public class April30th {

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }

        int startCost = grid[0][0] == 0 ? 0 : 1;

        if (startCost > k) {
            return -1;
        }

        dp[0][0][startCost] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == -1) {
                        continue;
                    }

                    if (i + 1 < m) {
                        int nv = grid[i + 1][j];
                        int nc = c + (nv == 0 ? 0 : 1);

                        if (nc <= k) {
                            dp[i + 1][j][nc] = Math.max(dp[i + 1][j][nc], dp[i][j][c] + nv);
                        }
                    }

                    if (j + 1 < n) {
                        int nv = grid[i][j + 1];
                        int nc = c + (nv == 0 ? 0 : 1);

                        if (nc <= k) {
                            dp[i][j + 1][nc] = Math.max(dp[i][j + 1][nc], dp[i][j][c] + nv);
                        }
                    }
                }
            }
        }

        int answer = -1;

        for (int c = 0; c <= k; c++) {
            answer = Math.max(answer, dp[m - 1][n - 1][c]);
        }

        return answer;
    }
}
