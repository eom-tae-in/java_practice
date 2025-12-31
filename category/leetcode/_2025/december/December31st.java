package category.leetcode._2025.december;

import java.util.ArrayDeque;
import java.util.Queue;

public class December31st {

    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1;
        int right = cells.length;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(mid, row, col, cells)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int day, int row, int col, int[][] cells) {
        int[][] grid = new int[row][col];

        for (int i = 0; i < day; i++) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            grid[x][y] = 1;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 0) {
                queue.offer(j);
                grid[0][j] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int id = queue.poll();
            int x = id / col;
            int y = id % col;

            for (int[] d : DIRS) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }

                if (grid[nx][ny] == 1) {
                    continue;
                }

                if (nx == row - 1) {
                    return true;
                }

                grid[nx][ny] = 1;
                queue.offer(nx * col + ny);
            }
        }

        return false;
    }
}
