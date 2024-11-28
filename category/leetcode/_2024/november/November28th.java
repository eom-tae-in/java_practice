package category.leetcode._2024.november;

import java.util.ArrayDeque;
import java.util.Deque;

public class November28th {

    public int minimumObstacles(final int[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int gridRowLength = grid.length;
        int gridColumnLength = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[gridRowLength][gridColumnLength];
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            int[] poll = deque.pollFirst();
            int rowIndex = poll[0];
            int columnIndex = poll[1];
            int obstacle = poll[2];

            if (rowIndex == gridRowLength - 1 && columnIndex == gridColumnLength - 1) {
                return obstacle;
            }

            for (int[] direction : directions) {
                int nextRowIndex = rowIndex + direction[0];
                int nextColumnIndex = columnIndex + direction[1];

                if (0 <= nextRowIndex && nextRowIndex < gridRowLength && 0 <= nextColumnIndex
                        && nextColumnIndex < gridColumnLength && !visited[nextRowIndex][nextColumnIndex]) {
                    if (grid[nextRowIndex][nextColumnIndex] == 1) {
                        deque.addLast(new int[]{nextRowIndex, nextColumnIndex, obstacle + 1});
                    } else {
                        deque.addFirst(new int[]{nextRowIndex, nextColumnIndex, obstacle});
                    }

                    visited[nextRowIndex][nextColumnIndex] = true;
                }
            }
        }

        return 0;
    }
}
