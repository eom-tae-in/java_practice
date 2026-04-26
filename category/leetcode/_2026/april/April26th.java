package category.leetcode._2026.april;

public class April26th {

    private static final int[] DIRS = {0, 1, 0, -1, 0};

    public boolean containsCycle(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (!visited[i][j] && dfs(i, j, -1, -1, grid[i][j], visited, grid)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(
            int currRow,
            int currCol,
            int parentRow,
            int parentCol,
            char target,
            boolean[][] visited,
            char[][] grid
    ) {
        visited[currRow][currCol] = true;

        for (int i = 0; i < DIRS.length - 1; i++) {
            int nr = currRow + DIRS[i];
            int nc = currCol + DIRS[i + 1];

            if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) {
                continue;
            }

            if (grid[nr][nc] != target) {
                continue;
            }

            if (nr == parentRow && nc == parentCol) {
                continue;
            }

            if (visited[nr][nc]) {
                return true;
            }

            if (dfs(nr, nc, currRow, currCol, target, visited, grid)) {
                return true;
            }
        }

        return false;
    }
}
