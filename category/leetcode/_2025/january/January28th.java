package category.leetcode._2025.january;

public class January28th {

    public int findMaxFish(final int[][] grid) {
        int maxFish = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    maxFish = Math.max(maxFish, dfs(grid, i, j));
                }
            }
        }

        return maxFish;
    }

    private int dfs(final int[][] grid, final int x, final int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }

        int fishCount = grid[x][y];
        grid[x][y] = 0;

        fishCount += dfs(grid, x + 1, y);
        fishCount += dfs(grid, x - 1, y);
        fishCount += dfs(grid, x, y + 1);
        fishCount += dfs(grid, x, y - 1);

        return fishCount;
    }
}
