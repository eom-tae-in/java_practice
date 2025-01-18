package category.leetcode._2025.january;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class January18th {

    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(final int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[][] mem = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        Arrays.stream(mem)
                .forEach(row -> Arrays.fill(row, -1));
        dfs(grid, 0, 0, 0, q, mem);

        for (int cost = 1; !q.isEmpty(); ++cost) {
            for (int sz = q.size(); sz > 0; --sz) {
                int[] cell = q.poll();
                int i = cell[0];
                int j = cell[1];
                for (int[] dir : dirs) {
                    dfs(grid, i + dir[0], j + dir[1], cost, q, mem);
                }
            }
        }

        return mem[m - 1][n - 1];
    }

    private void dfs(
            final int[][] grid,
            final int i,
            final int j,
            final int cost,
            final Queue<int[]> queue,
            final int[][] mem
    ) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return;
        }
        if (mem[i][j] != -1) {
            return;
        }

        mem[i][j] = cost;
        queue.add(new int[]{i, j});
        int[] dir = dirs[grid[i][j] - 1];
        dfs(grid, i + dir[0], j + dir[1], cost, queue, mem);
    }
}
