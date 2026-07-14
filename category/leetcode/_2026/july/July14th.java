package category.leetcode._2026.july;

public class July14th {

    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        long[][] dp = new long[max + 1][max + 1];
        dp[0][0] = 1;

        for (int num : nums) {
            long[][] next = new long[max + 1][max + 1];

            for (int g1 = 0; g1 <= max; g1++) {
                for (int g2 = 0; g2 <= max; g2++) {
                    long ways = dp[g1][g2];

                    if (ways == 0) {
                        continue;
                    }

                    next[g1][g2] = (next[g1][g2] + ways) % MOD;

                    int ng1 = gcd(g1, num);
                    next[ng1][g2] = (next[ng1][g2] + ways) % MOD;

                    int ng2 = gcd(g2, num);
                    next[g1][ng2] = (next[g1][ng2] + ways) % MOD;
                }
            }

            dp = next;
        }

        long answer = 0;

        for (int g = 1; g <= max; g++) {
            answer = (answer + dp[g][g]) % MOD;
        }

        return (int) answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
