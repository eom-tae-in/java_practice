package category.leetcode._2025.june;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class June25th {

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        List<Integer> negNums1 = new ArrayList<>();
        List<Integer> posNums1 = new ArrayList<>();
        List<Integer> negNums2 = new ArrayList<>();
        List<Integer> posNums2 = new ArrayList<>();
        separate(nums1, negNums1, posNums1);
        separate(nums2, negNums2, posNums2);
        int negativeCount = negNums1.size() * posNums2.size() + negNums2.size() * posNums1.size();
        int sign = 1;

        if (k > negativeCount) {
            k -= negativeCount;
        } else {
            k = negativeCount - k + 1;
            List<Integer> temp = negNums2;
            negNums2 = posNums2;
            posNums2 = temp;
            sign = -1;
        }

        long left = 0;
        long right = 10_000_000_000L;

        while (left < right) {
            long mid = (left + right) / 2;
            long count = calculateProductCount(negNums1, negNums2, mid) +
                    calculateProductCount(posNums1, posNums2, mid);

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return sign * left;
    }

    private void separate(int[] nums, List<Integer> negative, List<Integer> positive) {
        for (int num : nums) {
            if (num < 0) {
                negative.add(-num);
            } else {
                positive.add(num);
            }
        }

        Collections.reverse(negative);
    }

    private long calculateProductCount(List<Integer> primary, List<Integer> secondary, long condition) {
        long count = 0;
        int j = secondary.size() - 1;

        for (long num : primary) {
            while (j >= 0 && num * secondary.get(j) > condition) {
                j--;
            }

            count += j + 1;
        }

        return count;
    }
}
