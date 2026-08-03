package category.leetcode._2026.august;

public class August3rd {

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int take = 0;
            dp[i] = Integer.MIN_VALUE;

            for (int j = 0; j < 3 && i + j < n; j++) {
                take += stoneValue[i + j];
                dp[i] = Math.max(dp[i], take - dp[i + j + 1]);
            }
        }

        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        }

        return "Tie";
    }
}
