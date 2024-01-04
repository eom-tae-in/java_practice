package category.leetcode._2023.august;

public class August13th {
    public boolean validPartition(int[] nums) {
        final int num = nums.length;
        boolean[] dp = new boolean[num + 1];
        dp[0] = true;
        dp[2] = nums[0] == nums[1];
        for (int i = 3; i <= num; ++i) {
            dp[i] = (dp[i - 2] && (nums[i - 2] == nums[i - 1])) ||
                    (dp[i - 3] && ((nums[i - 3] == nums[i - 2] && nums[i - 2] == nums[i - 1]) ||
                            (nums[i - 3] + 1 == nums[i - 2] && nums[i - 2] + 1 == nums[i - 1])));
        }
        return dp[num];
    }
}
