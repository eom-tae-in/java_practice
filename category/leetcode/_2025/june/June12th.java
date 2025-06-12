package category.leetcode._2025.june;

public class June12th {

    public int maxAdjacentDistance(int[] nums) {
        int numsLength = nums.length;
        int maxDiff = Math.abs(nums[numsLength - 1] - nums[0]);

        for (int i = 1; i < numsLength; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i - 1]));
        }

        return maxDiff;
    }
}
