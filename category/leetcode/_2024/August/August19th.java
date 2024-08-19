package category.leetcode._2024.August;

public class August19th {

    public int minSteps(final int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            dp[i] = i;
            for (int j = i / 2; j > 2; --j) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }

        return dp[n];
    }
}
