package category.leetcode._2024.july;

import java.util.Arrays;

public class July3rd {

    public int minDifference(final int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int answer = Integer.MAX_VALUE;
        if (n <= 4) {
            return 0;
        }
        for (int i = 0; i <= 3; i++) {
            answer = Math.min(answer, nums[n - 4 + i] - nums[i]);
        }

        return answer;
    }
}
