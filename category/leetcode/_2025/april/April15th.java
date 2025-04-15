package category.leetcode._2025.april;

import java.util.HashMap;
import java.util.Map;

public class April15th {

    public long goodTriplets(final int[] nums1, final int[] nums2) {
        int n = nums1.length;
        long answer = 0;
        Map<Integer, Integer> numToIndex = new HashMap<>();
        int[] arr = new int[n];
        int[] leftSmaller = new int[n];
        int[] rightLarger = new int[n];
        FenwickTree tree1 = new FenwickTree(n);
        FenwickTree tree2 = new FenwickTree(n);

        for (int i = 0; i < n; ++i) {
            numToIndex.put(nums1[i], i);
        }

        for (int i = 0; i < n; ++i) {
            arr[i] = numToIndex.get(nums2[i]);
        }

        for (int i = 0; i < n; ++i) {
            leftSmaller[i] = tree1.get(arr[i]);
            tree1.add(arr[i] + 1, 1);
        }

        for (int i = n - 1; i >= 0; --i) {
            rightLarger[i] = tree2.get(n) - tree2.get(arr[i]);
            tree2.add(arr[i] + 1, 1);
        }

        for (int i = 0; i < n; ++i) {
            answer += (long) leftSmaller[i] * rightLarger[i];
        }

        return answer;
    }

    private static class FenwickTree {

        private final int[] sums;

        private FenwickTree(final int n) {
            sums = new int[n + 1];
        }

        private void add(int i, int delta) {
            while (i < sums.length) {
                sums[i] += delta;
                i += lowbit(i);
            }
        }

        private int get(int i) {
            int sum = 0;

            while (i > 0) {
                sum += sums[i];
                i -= lowbit(i);
            }

            return sum;
        }

        private int lowbit(final int i) {
            return i & -i;
        }
    }
}




