package category.leetcode._2026.november;

public class November10th {

    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int minCost = dp[i - 1] + 1;

            if (i >= 2) {
                minCost = Math.min(minCost, dp[i - 2] + 4);
            }

            if (i >= 3) {
                minCost = Math.min(minCost, dp[i - 3] + 9);
            }

            dp[i] = minCost + costs[i - 1];
        }

        return dp[n];
    }
}
