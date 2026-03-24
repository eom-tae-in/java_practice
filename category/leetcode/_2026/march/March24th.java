package category.leetcode._2026.march;

public class March24th {

    private static final int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] answer = new int[n][m];
        long prefix = 1;

        for (int idx = 0; idx < n * m; idx++) {
            int r = idx / m;
            int c = idx % m;
            answer[r][c] = (int) prefix;
            prefix = (prefix * grid[r][c]) % MOD;
        }

        long suffix = 1;

        for (int idx = n * m - 1; idx >= 0; idx--) {
            int r = idx / m;
            int c = idx % m;
            answer[r][c] = (int) ((answer[r][c] * suffix) % MOD);
            suffix = (suffix * grid[r][c]) % MOD;
        }

        return answer;
    }
}
