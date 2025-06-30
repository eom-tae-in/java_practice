package category.leetcode._2025.june;

import java.util.Arrays;

public class June30th {

    public int findLHS(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }

            if (nums[right] - nums[left] == 1) {
                answer = Math.max(answer, right - left + 1);
            }
        }

        return answer;
    }
}
