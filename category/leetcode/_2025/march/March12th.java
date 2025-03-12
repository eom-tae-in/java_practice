package category.leetcode._2025.march;

public class March12th {

    public int maximumCount(final int[] nums) {
        int numsLength = nums.length;
        int positiveCount = 0;
        int negativeCount = 0;
        int left = 0;
        int right = numsLength - 1;

        while (left < numsLength && nums[left] < 0) {
            left++;
            negativeCount++;
        }

        while (-1 < right && nums[right] > 0) {
            right--;
            positiveCount++;
        }

        return Math.max(negativeCount, positiveCount);
    }
}
