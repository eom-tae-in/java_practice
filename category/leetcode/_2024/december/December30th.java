package category.leetcode._2024.december;

public class December30th {

    public int countGoodStrings(final int low, final int high, final int zero, final int one) {
        int kMod = 1_000_000_007;
        int answer = 0;
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int i = 1; i <= high; ++i) {
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % kMod;
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % kMod;
            }
            if (i >= low) {
                answer = (answer + dp[i]) % kMod;
            }
        }

        return answer;
    }
}
