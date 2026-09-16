package category.leetcode._2026.september;

public class September16th {

    private static final long MOD = 1_000_000_007L;

    public int numberOfSets(int n, int k) {
        int size = n + k - 1;
        long[] factorial = new long[size + 1];
        factorial[0] = 1;

        for (int i = 1; i <= size; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        long denominator = factorial[2 * k] * factorial[size - 2 * k] % MOD;

        return (int) (factorial[size] * power(denominator, MOD - 2) % MOD);
    }

    private long power(long base, long exponent) {
        long result = 1;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exponent >>= 1;
        }

        return result;
    }
}
