package category.leetcode._2025.september;

public class September9th {

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long answer = 0;
        long share = 0;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        int mod = 1_000_000_007;

        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) {
                share = (share + dp[day - delay]) % mod;
            }

            if (day - forget >= 1) {
                share = (share - dp[day - forget]) % mod;

                if (share < 0) {
                    share += mod;
                }
            }

            dp[day] = share;
        }

        for (int i = n - forget + 1; i <= n; i++) {
            answer = (answer + dp[i]) % mod;
        }

        return (int) answer;
    }
}
