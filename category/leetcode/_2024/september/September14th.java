package category.leetcode._2024.september;

public class September14th {

    public int longestSubarray(final int[] nums) {
        int answer = 0;
        int maxIndex = 0;
        int sameNumLength = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == nums[maxIndex]) {
                answer = Math.max(answer, ++sameNumLength);
            } else if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
                sameNumLength = 1;
                answer = 1;
            } else {
                sameNumLength = 0;
            }
        }

        return answer;
    }
}
