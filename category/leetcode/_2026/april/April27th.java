package category.leetcode._2026.april;

public class April27th {

    private static final int[][] DIRS = {
            {-1, 0}, // up
            {0, 1},  // right
            {1, 0},  // down
            {0, -1}  // left
    };

    // 각 street type이 열려 있는 방향
    private static final int[][] PATHS = {
            {},          // dummy
            {1, 3},      // 1: left, right
            {0, 2},      // 2: up, down
            {2, 3},      // 3: left, down
            {1, 2},      // 4: right, down
            {0, 3},      // 5: left, up
            {0, 1}       // 6: right, up
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        return dfs(0, 0, grid, visited);
    }

    private boolean dfs(int r, int c, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        if (r == m - 1 && c == n - 1) {
            return true;
        }

        visited[r][c] = true;
        int type = grid[r][c];

        for (int dir : PATHS[type]) {
            int nr = r + DIRS[dir][0];
            int nc = c + DIRS[dir][1];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }

            if (visited[nr][nc]) {
                continue;
            }

            if (!canConnect(grid[nr][nc], dir)) {
                continue;
            }

            if (dfs(nr, nc, grid, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean canConnect(int nextType, int fromDir) {
        int oppositeDir = (fromDir + 2) % 4;

        for (int dir : PATHS[nextType]) {
            if (dir == oppositeDir) {
                return true;
            }
        }

        return false;
    }
}
