package category.leetcode._2026.october;

public class October28th {

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] dp = new boolean[n][1024];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                boolean[] next = new boolean[1024];
                int value = grid[r][c];

                if (r == 0 && c == 0) {
                    next[value] = true;
                } else {
                    for (int x = 0; x < 1024; x++) {
                        boolean fromTop = r > 0 && dp[c][x];
                        boolean fromLeft = c > 0 && dp[c - 1][x];

                        if (fromTop || fromLeft) {
                            next[x ^ value] = true;
                        }
                    }
                }

                dp[c] = next;
            }
        }

        for (int x = 0; x < 1024; x++) {
            if (dp[n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}
