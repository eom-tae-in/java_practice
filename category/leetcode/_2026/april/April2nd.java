package category.leetcode._2026.april;

import java.util.Arrays;

public class April2nd {

    private static final int INIT = Integer.MIN_VALUE / 2;
    private static final int ABILITY_THRESHOLD = 2;

    public int maximumAmount(int[][] coins) {
        int rowLen = coins.length;
        int colLen = coins[0].length;
        int[][][] dp = new int[rowLen][colLen][ABILITY_THRESHOLD + 1];
        initialize(dp, coins[0][0]);

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                for (int k = 0; k <= ABILITY_THRESHOLD; k++) {
                    int curr = coins[i][j];

                    if (i > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k] + curr);
                    }

                    if (j > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k] + curr);
                    }

                    if (curr < 0 && k > 0) {
                        if (i > 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1]);
                        }

                        if (j > 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k - 1]);
                        }
                    }
                }
            }
        }

        return calculateMax(dp[rowLen - 1][colLen - 1]);
    }

    private int calculateMax(int[] candidates) {
        int answer = INIT;

        for (int candidate : candidates) {
            answer = Math.max(answer, candidate);
        }

        return answer;
    }

    private void initialize(int[][][] dp, int initValue) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], INIT);
            }
        }

        dp[0][0][0] = initValue;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
    }
}
