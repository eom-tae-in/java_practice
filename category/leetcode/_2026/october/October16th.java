package category.leetcode._2026.october;

import java.util.HashMap;
import java.util.Map;

public class October16th {

    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        FenwickTree tree = new FenwickTree(n);
        Map<Integer, Integer> lastPosition = new HashMap<>();
        long endingSum = 0;
        long answer = 0;

        for (int r = 1; r <= n; r++) {
            int value = nums[r - 1];
            int p = lastPosition.getOrDefault(value, 0);
            long countSum = tree.rangeSum(p + 1, r);
            endingSum = (endingSum + 2 * countSum + (r - p)) % MOD;
            answer = (answer + endingSum) % MOD;
            tree.rangeAdd(p + 1, r, 1);
            lastPosition.put(value, r);
        }

        return (int) answer;
    }

    private static class FenwickTree {

        private final int n;
        private final long[] bit1;
        private final long[] bit2;

        FenwickTree(int n) {
            this.n = n;
            this.bit1 = new long[n + 1];
            this.bit2 = new long[n + 1];
        }

        void rangeAdd(int left, int right, long value) {
            add(bit1, left, value);
            add(bit1, right + 1, -value);

            add(bit2, left, value * (left - 1));
            add(bit2, right + 1, -value * right);
        }

        long rangeSum(int left, int right) {
            return prefixSum(right) - prefixSum(left - 1);
        }

        private long prefixSum(int index) {
            return sum(bit1, index) * index - sum(bit2, index);
        }

        private void add(long[] bit, int index, long value) {
            while (index <= n) {
                bit[index] += value;
                index += index & -index;
            }
        }

        private long sum(long[] bit, int index) {
            long result = 0;

            while (index > 0) {
                result += bit[index];
                index -= index & -index;
            }

            return result;
        }
    }
}
