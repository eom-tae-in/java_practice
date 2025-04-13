package category.leetcode._2025.april;

public class April13th {

    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(final long n) {
        return (int) (modPow(4 * 5, n / 2) * (n % 2 == 1 ? 5 : 1) % MOD);
    }

    private long modPow(final long base, final long exponent) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent % 2 == 1) {
            return base * modPow(base, exponent - 1) % MOD;
        }

        return modPow(base * base % MOD, exponent / 2);
    }
}
