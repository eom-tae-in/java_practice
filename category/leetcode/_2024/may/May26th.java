package category.leetcode._2024.may;

import java.util.Arrays;

public class May26th {

    public int checkRecord(int n) {
        final int mod = 1_000_000_007;
        long[][] dp = new long[2][3];
        dp[0][0] = 1;

        while (n-- > 0) {
            long[][] prev = Arrays.stream(dp)
                    .map(long[]::clone)
                    .toArray(long[][]::new);

            dp[0][0] = (prev[0][0] + prev[0][1] + prev[0][2]) % mod;
            dp[0][1] = prev[0][0];
            dp[0][2] = prev[0][1];
            dp[1][0] = (prev[0][0] + prev[0][1] + prev[0][2] + prev[1][0] + prev[1][1] + prev[1][2]) % mod;
            dp[1][1] = prev[1][0];
            dp[1][2] = prev[1][1];
        }

        return (int) ((dp[0][0] + dp[0][1] + dp[0][2] + dp[1][0] + dp[1][1] + dp[1][2]) % mod);
    }
}
