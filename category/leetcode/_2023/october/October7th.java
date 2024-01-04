package category.leetcode._2023.october;

public class October7th {

    public int numOfArrays(int n, int m, int k) {
        int mod = 1_000_000_007;
        int[][] dp = new int[m + 1][k + 1];
        int[][] preDp = new int[m + 1][k + 1];
        int[][] prefix = new int[m + 1][k + 1];
        int[][] prePrefix = new int[m + 1][k + 1];
        for (int i = 1; i <= m; i++) {
            preDp[i][1] = 1;
            prePrefix[i][1] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int cost = 1; cost <= k; cost++) {
                    dp[j][cost] = (int) (((long) j * preDp[j][cost] + prePrefix[j - 1][cost - 1]) % mod);
                    prefix[j][cost] = (dp[j][cost] + prefix[j - 1][cost]) % mod;
                }
            }
            for (int j = 1; j <= m; j++) {
                System.arraycopy(dp[j], 0, preDp[j], 0, k + 1);
                System.arraycopy(prefix[j], 0, prePrefix[j], 0, k + 1);
            }
        }
        return prefix[m][k];
    }
}
