package category.leetcode._2026.october;

import java.util.ArrayDeque;
import java.util.Queue;

public class October25th {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            floodFill(grid, r, 0, queue);
            floodFill(grid, r, cols - 1, queue);
        }

        for (int c = 0; c < cols; c++) {
            floodFill(grid, 0, c, queue);
            floodFill(grid, rows - 1, c, queue);
        }

        int count = 0;

        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r][c] == 0) {
                    count++;
                    floodFill(grid, r, c, queue);
                }
            }
        }

        return count;
    }

    private void floodFill(int[][] grid, int r, int c, Queue<Integer> queue) {
        if (grid[r][c] == 1) {
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        grid[r][c] = 1;
        queue.offer(r * cols + c);

        while (!queue.isEmpty()) {
            int position = queue.poll();
            int currentR = position / cols;
            int currentC = position % cols;

            for (int d = 0; d < 4; d++) {
                int nextR = currentR + DR[d];
                int nextC = currentC + DC[d];

                if (nextR < 0 || nextR >= rows || nextC < 0 || nextC >= cols || grid[nextR][nextC] == 1) {
                    continue;
                }

                grid[nextR][nextC] = 1;
                queue.offer(nextR * cols + nextC);
            }
        }
    }
}
