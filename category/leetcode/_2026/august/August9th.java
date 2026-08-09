package category.leetcode._2026.august;

public class August9th {

    private int[] suffix;
    private int[][] dp;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffix = new int[n + 1];
        dp = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return dfs(0, 1);
    }

    private int dfs(int index, int m) {
        if (index + 2 * m >= n) {
            return suffix[index];
        }

        if (dp[index][m] != 0) {
            return dp[index][m];
        }

        int max = 0;

        for (int x = 1; x <= 2 * m; x++) {
            int opponent = dfs(index + x, Math.max(m, x));
            int current = suffix[index] - opponent;
            max = Math.max(max, current);
        }

        return dp[index][m] = max;
    }
}
