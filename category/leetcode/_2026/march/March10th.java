package category.leetcode._2026.march;

public class March10th {

    private static final int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        int m = Math.max(zero, one);
        int[][] ways = new int[m + 1][m + 1];
        int[] prefix = new int[m + 1];
        ways[0][0] = 1;

        for (int block = 1; block <= m; block++) {
            int maxSum = Math.min(block * limit, m);
            int running = 0;

            for (int i = 0; i <= maxSum; i++) {
                prefix[i] = running;
                running = (running + ways[block - 1][i]) % MOD;
            }

            for (int sum = block; sum <= maxSum; sum++) {
                if (sum < limit) {
                    ways[block][sum] = prefix[sum];
                } else {
                    ways[block][sum] = (prefix[sum] - prefix[sum - limit] + MOD) % MOD;
                }
            }
        }

        long result = (m <= limit) ? 2 : 0;
        int prevZeroWays = ways[1][zero];
        int prevOneWays = ways[1][one];

        for (int block = 2; block <= m; block++) {
            int zeroWays = ways[block][zero];
            int oneWays = ways[block][one];
            result = (result + (long) zeroWays * prevOneWays) % MOD;
            result = (result + (long) oneWays * prevZeroWays) % MOD;
            long both = (long) zeroWays * oneWays % MOD;
            result = (result + both + both) % MOD;
            prevZeroWays = zeroWays;
            prevOneWays = oneWays;
        }

        return (int) result;
    }
}
