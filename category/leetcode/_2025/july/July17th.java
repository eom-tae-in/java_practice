package category.leetcode._2025.july;

public class July17th {

    public int maximumLength(int[] nums, int k) {
        int answer = 0;
        int[][] dp = new int[k][k];

        for (int num : nums) {
            int x = num % k;

            for (int y = 0; y < k; y++) {
                dp[x][y] = dp[y][x] + 1;
                answer = Math.max(answer, dp[x][y]);
            }
        }

        return answer;
    }
}
