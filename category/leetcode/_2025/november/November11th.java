package category.leetcode._2025.november;

public class November11th {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int ones = 0;
            int zeros = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    ones++;
                } else {
                    zeros++;
                }
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
