package category.leetcode._2025.december;

public class December17th {

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;

        if (n == 0 || k == 0) {
            return 0L;
        }

        long[][] dp = new long[k + 1][3];

        for (int t = 0; t <= k; t++) {
            dp[t][0] = 0;
            dp[t][1] = Long.MIN_VALUE / 4;
            dp[t][2] = Long.MIN_VALUE / 4;
        }

        for (int price : prices) {
            long[][] prev = new long[k + 1][3];

            for (int t = 0; t <= k; t++) {
                prev[t][0] = dp[t][0];
                prev[t][1] = dp[t][1];
                prev[t][2] = dp[t][2];
            }

            for (int t = 0; t <= k; t++) {
                dp[t][0] = prev[t][0];
                dp[t][1] = Math.max(prev[t][1], prev[t][0] - price);
                dp[t][2] = Math.max(prev[t][2], prev[t][0] + price);

                if (t > 0) {
                    dp[t][0] = Math.max(dp[t][0], Math.max(prev[t - 1][1] + price, prev[t - 1][2] - price));
                }
            }
        }

        long answer = 0;

        for (int t = 0; t <= k; t++) {
            answer = Math.max(answer, dp[t][0]);
        }

        return answer;
    }
}
