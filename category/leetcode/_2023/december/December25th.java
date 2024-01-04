package category.leetcode._2023.december;

public class December25th {

    public int numDecoding(final String s) {
        final int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = canEncoding(s.charAt(n - 1)) ? 1 : 0;

        for (int i = n - 2; i >= 0; --i) {
            if (canEncoding(s.charAt(i))) {
                dp[i] += dp[i + 1];
            }
            if (canEncoding(s.charAt(i), s.charAt(i + 1))) {
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
    }

    private boolean canEncoding(final char c) {
        return c != '0';
    }

    private boolean canEncoding(final char c1, final char c2) {
        return c1 == '1' || c1 == '2' && c2 < '7';
    }
}
