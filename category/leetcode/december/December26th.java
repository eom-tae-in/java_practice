package category.leetcode.december;

public class December26th {

    public int numRollsToTarget(int n, int k, int target) {
        final int mod = 1_000_000_007;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        while (n-- > 0) {
            int[] newDp = new int[target + 1];
            for (int i = 1; i <= k; i++) {
                for (int j = i; j <= target; j++) {
                    newDp[j] += dp[j - i];
                    newDp[j] %= mod;
                }
            }
            dp = newDp;
        }

        return dp[target];
    }
}
