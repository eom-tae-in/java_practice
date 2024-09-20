package category.leetcode._2024.august;

public class August11th {

    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minDays(final int[][] grid) {
        if (disconnected(grid)) {
            return 0;
        }

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (disconnected(grid)) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }


    private boolean disconnected(final int[][] grid) {
        int islandsCount = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0 || seen[i][j]) {
                    continue;
                }
                if (++islandsCount > 1) {
                    return true;
                }
                dfs(grid, i, j, seen);
            }
        }

        return islandsCount != 1;
    }

    private void dfs(final int[][] grid, final int i, final int j, final boolean[][] seen) {
        seen[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x == grid.length || y < 0 || y == grid[0].length) {
                continue;
            }
            if (grid[x][y] == 0 || seen[x][y]) {
                continue;
            }
            dfs(grid, x, y, seen);
        }
    }
}
