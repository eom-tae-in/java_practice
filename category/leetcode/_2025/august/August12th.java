package category.leetcode._2025.august;

public class August12th {

    public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        int mod = 1_000_000_007;
        dp[0] = 1;

        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int current = (int) Math.pow(i, x);

            for (int j = n; j >= current; j--) {
                dp[j] = (dp[j] + dp[j - current]) % mod;
            }
        }

        return dp[n];
    }
}
