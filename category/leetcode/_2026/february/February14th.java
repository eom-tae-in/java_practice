package category.leetcode._2026.february;

public class February14th {

    public double champagneTower(int poured, int queryRow, int queryGlass) {
        double[][] dp = new double[queryRow + 1][queryRow + 1];
        dp[0][0] = poured;

        for (int i = 0; i < queryRow; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (dp[i][j] > 1) {
                    dp[i + 1][j] += (dp[i][j] - 1) / 2.0;
                    dp[i + 1][j + 1] += (dp[i][j] - 1) / 2.0;
                }
            }
        }

        return Math.min(1.0, dp[queryRow][queryGlass]);
    }
}
