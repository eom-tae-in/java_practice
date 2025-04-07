package category.leetcode._2025.april;

import java.util.Arrays;

public class April7th {

    public boolean canPartition(final int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 == 1) {
            return false;
        }

        return knapsack(nums, sum / 2);
    }

    private boolean knapsack(final int[] nums, final int subsetSum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][subsetSum + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; ++i) {
            int num = nums[i - 1];

            for (int j = 0; j <= subsetSum; ++j) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
        }

        return dp[n][subsetSum];
    }
}
