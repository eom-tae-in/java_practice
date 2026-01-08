package category.leetcode._2026.january;

public class January8th {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE / 2;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int curr = nums1[i] * nums2[j];

                dp[i][j] = Math.max(
                        Math.max(curr, curr + dp[i + 1][j + 1]),
                        Math.max(dp[i + 1][j], dp[i][j + 1])
                );
            }
        }

        return dp[0][0];
    }
}
