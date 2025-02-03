package category.leetcode._2025.february;

public class February3rd {

    public int longestMonotonicSubarray(final int[] nums) {
        int incresingCount = 1;
        int decresingCount = 1;
        int answer = 1;
        int numsLength = nums.length;

        for (int i = 1; i < numsLength; i++) {
            if (nums[i] > nums[i - 1]) {
                incresingCount++;
                decresingCount = 1;
            } else if (nums[i] < nums[i - 1]) {
                decresingCount++;
                incresingCount = 1;
            } else {
                incresingCount = 1;
                decresingCount = 1;
            }

            answer = Math.max(answer, Math.max(decresingCount, incresingCount));
        }

        return answer;
    }
}
