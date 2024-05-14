package category.leetcode._2024.May;

public class May14th {

    public int getMaximumGold(final int[][] grid) {
        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                answer = Math.max(answer, dfs(grid, i, j));
            }
        }

        return answer;
    }

    private int dfs(final int[][] grid, final int y, final int x) {
        if (y < 0 || x < 0 || y == grid.length || x == grid[0].length) {
            return 0;
        }

        if (grid[y][x] == 0) {
            return 0;
        }

        int gold = grid[y][x];
        grid[y][x] = 0;
        int pathMaxGold = Math.max(Math.max(dfs(grid, y + 1, x), dfs(grid, y - 1, x)),
                Math.max(dfs(grid, y, x + 1), dfs(grid, y, x - 1)));
        grid[y][x] = gold;

        return gold + pathMaxGold;
    }
}
