package category.leetcode._2024.august;

import java.util.Arrays;

public class August14th {

    public int smallestDistancePair(final int[] nums, final int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            final int m = (left + right) / 2;
            if (numPairDistancesNoGreaterThan(nums, m) >= k) {
                right = m;
            } else {
                left = m + 1;
            }
        }

        return left;
    }

    private int numPairDistancesNoGreaterThan(final int[] nums, final int m) {
        int count = 0;
        int j = 1;
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length && nums[j] <= nums[i] + m) {
                ++j;
            }
            count += j - i - 1;
        }

        return count;
    }
}
