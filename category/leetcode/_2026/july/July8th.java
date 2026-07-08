package category.leetcode._2026.july;

public class July8th {

    private static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] prefixValue = new long[n + 1];
        long[] prefixSum = new long[n + 1];
        int[] prefixCount = new int[n + 1];
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            prefixValue[i + 1] = prefixValue[i];
            prefixSum[i + 1] = prefixSum[i];
            prefixCount[i + 1] = prefixCount[i];

            if (digit != 0) {
                prefixValue[i + 1] = (prefixValue[i] * 10 + digit) % MOD;
                prefixSum[i + 1] += digit;
                prefixCount[i + 1]++;
            }

            pow10[i + 1] = pow10[i] * 10 % MOD;
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int count = prefixCount[r + 1] - prefixCount[l];
            long x = (prefixValue[r + 1] - prefixValue[l] * pow10[count] % MOD + MOD) % MOD;
            long sum = prefixSum[r + 1] - prefixSum[l];
            answer[i] = (int) (x * sum % MOD);
        }

        return answer;
    }
}
