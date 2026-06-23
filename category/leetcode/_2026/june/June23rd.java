package category.leetcode._2026.june;

public class June23rd {

    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        long[] up = new long[m];
        long[] down = new long[m];

        for (int v = 0; v < m; v++) {
            up[v] = v;
            down[v] = m - 1 - v;
        }

        for (int len = 3; len <= n; len++) {
            long[] prefUp = new long[m];
            long[] prefDown = new long[m];
            prefUp[0] = up[0];
            prefDown[0] = down[0];

            for (int i = 1; i < m; i++) {
                prefUp[i] = (prefUp[i - 1] + up[i]) % MOD;
                prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;
            }

            long totalUp = prefUp[m - 1];
            long[] nextUp = new long[m];
            long[] nextDown = new long[m];

            for (int v = 0; v < m; v++) {
                nextUp[v] = (v > 0) ? prefDown[v - 1] : 0;
                nextDown[v] = (totalUp - prefUp[v] + MOD) % MOD;
            }

            up = nextUp;
            down = nextDown;
        }

        long answer = 0;

        for (int v = 0; v < m; v++) {
            answer = (answer + up[v] + down[v]) % MOD;
        }

        return (int) answer;
    }
}
