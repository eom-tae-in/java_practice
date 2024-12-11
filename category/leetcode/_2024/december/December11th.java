package category.leetcode._2024.december;

import java.util.Arrays;

public class December11th {

    public int maximumBeauty(final int[] nums, final int k) {
        int numsLength = nums.length;
        int left = 0;
        int right = 0;
        Arrays.sort(nums);

        for (; right < numsLength; right++) {
            if (nums[right] - nums[left] > 2 * k) {
                left++;
            }
        }

        return right - left;
    }
}
