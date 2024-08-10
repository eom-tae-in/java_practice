package category.leetcode._2024.August;

public class August10th {

    public int regionsBySlashes(final String[] grid) {
        final int n = grid.length;
        int[][] g = new int[n * 3][n * 3];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i].charAt(j) == '/') {
                    g[i * 3][j * 3 + 2] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    g[i * 3][j * 3] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n * 3; ++i) {
            for (int j = 0; j < n * 3; ++j) {
                if (g[i][j] == 0) {
                    dfs(g, i, j);
                    ++answer;
                }
            }
        }

        return answer;
    }

    private void dfs(final int[][] g, final int i, final int j) {
        if (i < 0 || i == g.length || j < 0 || j == g[0].length) {
            return;
        }
        if (g[i][j] != 0) {
            return;
        }
        g[i][j] = 2;
        dfs(g, i + 1, j);
        dfs(g, i - 1, j);
        dfs(g, i, j + 1);
        dfs(g, i, j - 1);
    }
}
