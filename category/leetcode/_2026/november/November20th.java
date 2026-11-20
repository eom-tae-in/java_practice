package category.leetcode._2026.november;

import java.util.Arrays;

public class November20th {

    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int maxValue = nums[nums.length - 1];
        int[] dp = new int[maxValue + 2];
        int answer = 0;

        for (int x : nums) {
            dp[x + 1] = Math.max(dp[x + 1], dp[x] + 1);
            dp[x] = Math.max(dp[x], dp[x - 1] + 1);
            answer = Math.max(answer, Math.max(dp[x], dp[x + 1]));
        }

        return answer;
    }
}
