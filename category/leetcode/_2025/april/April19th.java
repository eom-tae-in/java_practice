package category.leetcode._2025.april;

import java.util.Arrays;

public class April19th {

    public long countFairPairs(final int[] nums, final int lower, final int upper) {
        Arrays.sort(nums);
        return countPairs(nums, upper) - countPairs(nums, lower - 1);
    }

    private long countPairs(final int[] nums, final int condition) {
        long count = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] + nums[right] > condition) {
                right--;
            }

            count += right - left;
            left++;
        }

        return count;
    }
}
