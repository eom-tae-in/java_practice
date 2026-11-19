package category.leetcode._2026.november;

import java.util.Arrays;

public class November19th {

    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int changeTwoSmallest = nums[n - 1] - nums[2];
        int changeTwoLargest = nums[n - 3] - nums[0];
        int changeBothEnds = nums[n - 2] - nums[1];

        return Math.min(changeBothEnds, Math.min(changeTwoSmallest, changeTwoLargest));
    }
}
