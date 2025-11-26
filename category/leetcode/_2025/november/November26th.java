package category.leetcode._2025.november;

public class November26th {

    public int numberOfPaths(int[][] grid, int k) {
        int mod = 1_000_000_007;
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k];
        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int curr = grid[i][j];

                for (int prevM = 0; prevM < k; prevM++) {
                    int nextM = (prevM + curr) % k;

                    if (i > 0) {
                        dp[i][j][nextM] = (dp[i][j][nextM] + dp[i - 1][j][prevM]) % mod;
                    }

                    if (j > 0) {
                        dp[i][j][nextM] = (dp[i][j][nextM] + dp[i][j - 1][prevM]) % mod;
                    }
                }
            }
        }

        return dp[n - 1][m - 1][0];
    }
}
