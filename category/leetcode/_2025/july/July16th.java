package category.leetcode._2025.july;

public class July16th {

    public int maximumLength(int[] nums) {
        int answer = 0;
        int[][] dp = new int[2][2];

        for (int num : nums) {
            int x = num % 2;

            for (int y = 0; y < 2; y++) {
                dp[x][y] = dp[y][x] + 1;
                answer = Math.max(answer, dp[x][y]);
            }
        }

        return answer;
    }
}
