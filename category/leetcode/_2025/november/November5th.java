package category.leetcode._2025.november;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class November5th {

    private long windowSum = 0;

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Comparator<NumCount> comparator = Comparator.comparingInt((NumCount nc) -> nc.count)
                .thenComparingInt((NumCount nc) -> nc.num);
        Map<Integer, Integer> numCountMap = new HashMap<>();
        TreeSet<NumCount> top = new TreeSet<>(comparator);
        TreeSet<NumCount> bottom = new TreeSet<>(comparator);
        long[] answer = new long[n - k + 1];

        for (int i = 0; i < n; i++) {
            insert(nums[i], bottom, top, numCountMap);

            if (i >= k) {
                remove(nums[i - k], bottom, top, numCountMap);
            }

            while (!bottom.isEmpty() && top.size() < x) {
                NumCount bottomMax = bottom.pollLast();
                top.add(bottomMax);
                windowSum += (long) bottomMax.num * bottomMax.count;
            }

            while (isSwapNeeded(bottom, top)) {
                NumCount topMin = top.pollFirst();
                NumCount bottomMax = bottom.pollLast();
                top.add(bottomMax);
                bottom.add(topMin);
                windowSum -= (long) topMin.num * topMin.count;
                windowSum += (long) bottomMax.num * bottomMax.count;
            }

            if (i >= k - 1) {
                answer[i - k + 1] = windowSum;
            }
        }

        return answer;
    }

    private void insert(
            int num,
            TreeSet<NumCount> bottom,
            TreeSet<NumCount> top,
            Map<Integer, Integer> numCountMap
    ) {
        int oldFreq = numCountMap.getOrDefault(num, 0);
        int newFreq = oldFreq + 1;
        numCountMap.put(num, newFreq);
        NumCount oldNumCount = new NumCount(num, oldFreq);
        bottom.remove(oldNumCount);

        if (top.remove(oldNumCount)) {
            windowSum -= (long) num * oldFreq;
        }

        NumCount newNumCount = new NumCount(num, newFreq);
        bottom.add(newNumCount);
    }

    private void remove(
            int num,
            TreeSet<NumCount> bottom,
            TreeSet<NumCount> top,
            Map<Integer, Integer> numCountMap
    ) {
        int oldFreq = numCountMap.get(num);
        int newFreq = oldFreq - 1;
        NumCount oldNumCount = new NumCount(num, oldFreq);
        bottom.remove(oldNumCount);

        if (top.remove(oldNumCount)) {
            windowSum -= (long) num * oldFreq;
        }

        if (newFreq == 0) {
            numCountMap.remove(num);
        } else {
            numCountMap.put(num, newFreq);
            bottom.add(new NumCount(num, newFreq));
        }
    }

    private boolean isSwapNeeded(TreeSet<NumCount> bottom, TreeSet<NumCount> top) {
        return !bottom.isEmpty()
                && !top.isEmpty()
                && (
                bottom.last().count > top.first().count
                        || (
                        bottom.last().count == top.first().count
                                && bottom.last().num > top.first().num
                )
        );
    }

    private static class NumCount {

        private final int num;
        private final int count;

        private NumCount(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }

            NumCount numCount = (NumCount) o;

            return this.num == numCount.num && this.count == numCount.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, count);
        }
    }
}
