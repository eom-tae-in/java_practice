package category.leetcode._2026.november;

import java.util.Arrays;
import java.util.TreeMap;

public class November4th {

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        MedianWindow window = new MedianWindow();

        for (int i = 0; i < n; i++) {
            window.add(nums[i]);

            if (i >= x) {
                window.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = window.getCost();
            }
        }

        long inf = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int count = 1; count <= k; count++) {
            Arrays.fill(curr, inf);

            for (int i = count * x; i <= n; i++) {
                curr[i] = curr[i - 1];

                if (prev[i - x] != inf) {
                    curr[i] = Math.min(curr[i], prev[i - x] + cost[i - x]);
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }

    private static class MedianWindow {

        private final TreeMap<Integer, Integer> left = new TreeMap<>();
        private final TreeMap<Integer, Integer> right = new TreeMap<>();
        private int leftSize;
        private int rightSize;
        private long leftSum;
        private long rightSum;

        void add(int value) {
            if (left.isEmpty() || value <= left.lastKey()) {
                insert(left, value);
                leftSize++;
                leftSum += value;
            } else {
                insert(right, value);
                rightSize++;
                rightSum += value;
            }

            balance();
        }

        void remove(int value) {
            if (left.containsKey(value)) {
                erase(left, value);
                leftSize--;
                leftSum -= value;
            } else {
                erase(right, value);
                rightSize--;
                rightSum -= value;
            }

            balance();
        }

        long getCost() {
            long median = left.lastKey();

            return median * leftSize - leftSum + rightSum - median * rightSize;
        }

        private void balance() {
            while (leftSize > rightSize + 1) {
                int value = left.lastKey();
                erase(left, value);
                leftSize--;
                leftSum -= value;
                insert(right, value);
                rightSize++;
                rightSum += value;
            }

            while (leftSize < rightSize) {
                int value = right.firstKey();
                erase(right, value);
                rightSize--;
                rightSum -= value;
                insert(left, value);
                leftSize++;
                leftSum += value;
            }
        }

        private void insert(TreeMap<Integer, Integer> map, int value) {
            map.merge(value, 1, Integer::sum);
        }

        private void erase(TreeMap<Integer, Integer> map, int value) {
            int count = map.get(value);

            if (count == 1) {
                map.remove(value);
            } else {
                map.put(value, count - 1);
            }
        }
    }
}
