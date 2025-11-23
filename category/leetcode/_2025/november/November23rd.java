package category.leetcode._2025.november;

public class November23rd {

    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        dp[1] = Integer.MIN_VALUE;
        dp[2] = Integer.MIN_VALUE;

        for (int num : nums) {
            int[] next = dp.clone();

            for (int r = 0; r < 3; r++) {
                if (dp[r] == Integer.MIN_VALUE) {
                    continue;
                }

                int nextSum = dp[r] + num;
                int nextR = nextSum % 3;
                next[nextR] = Math.max(next[nextR], nextSum);
            }

            dp = next;
        }

        return dp[0];
    }
}
