package category.leetcode._2026.august;

public class Augst10th {

    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        for (int stones = 0; stones <= n; stones++) {
            if (!dp[stones]) {
                for (int i = 1; stones + i * i <= n; i++) {
                    dp[stones + i * i] = true;
                }
            }
        }

        return dp[n];
    }
}
