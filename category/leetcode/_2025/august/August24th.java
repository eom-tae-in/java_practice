package category.leetcode._2025.august;

public class August24th {

    public int longestSubarray(int[] nums) {
        int answer = 0;
        int numsLength = nums.length;
        int left = 0;
        int zeroCount = 0;

        for (int right = 0; right < numsLength; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left++] == 0) {
                    zeroCount--;
                }
            }

            answer = Math.max(answer, right - left);
        }

        return answer;
    }
}
