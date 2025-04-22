package category.leetcode._2025.april;

import java.util.ArrayList;
import java.util.List;

public class April22nd {

    private static final int MOD = 1_000_000_007;

    public int idealArrays(final int n, final int maxValue) {
        int maxLength = Math.min(14, n);
        List<Integer>[] factors = getFactors(maxValue);
        long[][] dp = new long[maxLength + 1][maxValue + 1];
        long answer = 0;

        for (int v = 1; v <= maxValue; v++) {
            dp[1][v] = 1;
        }

        for (int len = 2; len <= maxLength; len++) {
            for (int v = 1; v <= maxValue; v++) {
                for (int d : factors[v]) {
                    dp[len][v] = (dp[len][v] + dp[len - 1][d]) % MOD;
                }
            }
        }

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = modPow(fact[n], MOD - 2);

        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        for (int len = 1; len <= maxLength; len++) {
            long sumEndingHere = 0;

            for (int v = 1; v <= maxValue; v++) {
                sumEndingHere = (sumEndingHere + dp[len][v]) % MOD;
            }

            long waysToChoosePositions = nCk(n - 1, len - 1, fact, invFact);
            answer = (answer + sumEndingHere * waysToChoosePositions) % MOD;
        }

        return (int) answer;
    }

    private long modPow(long x, long y) {
        long res = 1;
        x %= MOD;

        while (y > 0) {
            if ((y & 1) == 1) {
                res = res * x % MOD;
            }

            x = x * x % MOD;
            y >>= 1;
        }

        return res;
    }

    private long nCk(
            final int n,
            final int k,
            final long[] fact,
            final long[] invFact
    ) {
        if (k < 0 || k > n) {
            return 0;
        }

        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    private List<Integer>[] getFactors(final int maxValue) {
        List<Integer>[] factors = new List[maxValue + 1];

        for (int i = 0; i <= maxValue; i++) {
            factors[i] = new ArrayList<>();
        }

        for (int d = 1; d <= maxValue; d++) {
            for (int multiple = d * 2; multiple <= maxValue; multiple += d) {
                factors[multiple].add(d);
            }
        }

        return factors;
    }
}
