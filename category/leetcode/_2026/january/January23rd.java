package category.leetcode._2026.january;

import java.util.Comparator;
import java.util.TreeSet;

public class January23rd {

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int answer = 0;
        int inversionsCount = 0;
        int[] next = new int[n];
        int[] prev = new int[n];
        long[] values = new long[n];

        for (int i = 0; i < n; i++) {
            values[i] = nums[i];
            next[i] = i + 1;
            prev[i] = i - 1;
        }

        TreeSet<PairSum> set = new TreeSet<>(Comparator.comparingLong((PairSum pairSum) -> pairSum.sum)
                .thenComparingInt((PairSum pairSum) -> pairSum.idx));

        for (int i = 0; i < n - 1; i++) {
            set.add(new PairSum(values[i] + values[i + 1], i));

            if (values[i + 1] < values[i]) {
                inversionsCount++;
            }
        }

        while (inversionsCount > 0) {
            answer++;
            PairSum smallest = set.pollFirst();
            int i = smallest.idx;
            long merged = smallest.sum;
            int j = next[i];
            int pi = prev[i];

            if (pi >= 0) {
                long oldSum = values[pi] + values[i];
                long newSum = values[pi] + merged;
                set.remove(new PairSum(oldSum, pi));
                set.add(new PairSum(newSum, pi));

                if (values[pi] > values[i]) {
                    inversionsCount--;
                }

                if (values[pi] > merged) {
                    inversionsCount++;
                }
            }

            if (values[j] < values[i]) {
                inversionsCount--;
            }

            int jj = next[j];

            if (jj < n) {
                long oldSum = values[j] + values[jj];
                long newSum = merged + values[jj];
                set.remove(new PairSum(oldSum, j));
                set.add(new PairSum(newSum, i));

                if (values[jj] < values[j]) {
                    inversionsCount--;
                }

                if (values[jj] < merged) {
                    inversionsCount++;
                }

                prev[jj] = i;
            }

            next[i] = jj;
            values[i] = merged;
        }

        return answer;
    }

    private static class PairSum {
        private final long sum;
        private final int idx;

        PairSum(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }
}
