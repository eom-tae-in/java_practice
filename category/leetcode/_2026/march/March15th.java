package category.leetcode._2026.march;

import java.util.ArrayList;
import java.util.List;

public class March15th {

    private static class Fancy {

        private static final int MOD = 1_000_000_007;
        private final List<Long> vals;
        private long a;
        private long b;

        private Fancy() {
            vals = new ArrayList<>();
            a = 1;
            b = 0;
        }

        public void append(int val) {
            long x = (val - b + MOD) % MOD;
            vals.add(x * modPow(a, MOD - 2) % MOD);
        }

        public void addAll(int inc) {
            b = (b + inc) % MOD;
        }

        public void multiplyAll(int m) {
            a = (a * m) % MOD;
            b = (b * m) % MOD;
        }

        public int getIndex(int idx) {
            return idx >= vals.size() ? -1 : (int) ((a * vals.get(idx) + b) % MOD);
        }

        private int modPow(long x, long n) {
            if (n == 0) {
                return 1;
            }

            if (n % 2 == 1) {
                return (int) (x * modPow(x % MOD, (n - 1)) % MOD);
            }

            return modPow(x * x % MOD, (n / 2)) % MOD;
        }
    }
}
