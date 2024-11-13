package category.leetcode._2024.november;

import java.util.Arrays;

public class November13th {

    public long countFairPairs(final int[] nums, final int lower, final int upper) {
        Arrays.sort(nums);

        return countLessSumPairs(upper, nums) - countLessSumPairs(lower - 1, nums);
    }

    private long countLessSumPairs(final int condition, final int[] nums) {
        long count = 0;
        int n = nums.length;

        for (int left = 0, right = n - 1; left < right; left++) {
            while (left < right && nums[left] + nums[right] > condition) {
                right--;
            }
            count += right - left;
        }

        return count;
    }
}
