package category.leetcode._2026.october;

public class October31st {

    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] down = new int[n];
        down[0] = 1;

        for (int i = 0; i < m; i++) {
            int right = 0;

            for (int j = 0; j < n; j++) {
                int fromAbove = down[j];
                int fromLeft = right;
                int total = (fromAbove + fromLeft) % MOD;

                if (i == m - 1 && j == n - 1) {
                    return total;
                }

                if (grid[i][j] == 1) {
                    down[j] = fromLeft;
                    right = fromAbove;
                } else {
                    down[j] = total;
                    right = total;
                }
            }
        }

        return 0;
    }
}
