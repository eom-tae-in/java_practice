package category.leetcode._2026.january;

import java.util.Arrays;

public class January25th {

    public int minimumDifference(int[] nums, int k) {
        int answer = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - k; i++) {
            int curr = nums[i + k - 1] - nums[i];
            answer = Math.min(answer, curr);
        }

        return answer;
    }
}
