package category.leetcode._2023.december;

import java.util.Arrays;

public class December18th {

    public int maxProductDifference(int[] nums) {
        int lastIndex = nums.length - 1;
        Arrays.sort(nums);

        return nums[lastIndex] * nums[lastIndex - 1] - nums[1] * nums[0];
    }
}
