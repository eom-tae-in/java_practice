package category.leetcode._2024.december;

import java.util.Arrays;

public class December26th {

    public int findTargetSumWays(final int[] nums, final int target) {
        int sum = Arrays.stream(nums)
                .sum();
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }
        return knapsack(nums, (sum + target) / 2);
    }

    private int knapsack(final int[] nums, final int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = target; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }

        return dp[target];
    }
}
