package category.leetcode._2025.january;

public class January28th {

    public int findMaxFish(final int[][] grid) {
        int answer = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] > 0) {
                    answer = Math.max(answer, dfs(grid, i, j));
                }
            }
        }

        return answer;
    }

    private int dfs(final int[][] grid, final int i, final int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid.length) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        int caughtFish = grid[i][j];
        grid[i][j] = 0;

        return caughtFish +
                dfs(grid, i + 1, j) + dfs(grid, i - 1, j) +
                dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }
}
