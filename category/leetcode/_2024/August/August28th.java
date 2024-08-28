package category.leetcode._2024.August;

public class August28th {

    public int countSubIslands(final int[][] grid1, final int[][] grid2) {
        int answer = 0;
        for (int i = 0; i < grid2.length; ++i) {
            for (int j = 0; j < grid2[0].length; ++j) {
                if (grid2[i][j] == 1) {
                    answer += dfs(grid1, grid2, i, j);
                }
            }
        }

        return answer;
    }

    private int dfs(final int[][] grid1, final int[][] grid2, final int i, final int j) {
        if (i < 0 || i == grid1.length || j < 0 || j == grid2[0].length) {
            return 1;
        }
        if (grid2[i][j] != 1) {
            return 1;
        }
        grid2[i][j] = 2;

        return dfs(grid1, grid2, i + 1, j) & dfs(grid1, grid2, i - 1, j) &
                dfs(grid1, grid2, i, j + 1) & dfs(grid1, grid2, i, j - 1) & grid1[i][j];
    }
}
