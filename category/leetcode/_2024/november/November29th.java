package category.leetcode._2024.november;

import java.util.PriorityQueue;
import java.util.Queue;

public class November29th {

    public int minimumTime(final int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        queue.offer(new int[]{0, 0, 0});
        int gridRowLength = grid.length;
        int gridColumnLength = grid[0].length;
        boolean[][] seen = new boolean[gridRowLength][gridColumnLength];
        seen[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int rowIndex = poll[0];
            int columnIndex = poll[1];
            int time = poll[2];

            if (rowIndex == gridRowLength - 1 && columnIndex == gridColumnLength - 1) {
                return time;
            }

            for (int[] direction : directions) {
                int nextRowIndex = rowIndex + direction[0];
                int nextColumnIndex = columnIndex + direction[1];

                if (isInvalidIndex(nextRowIndex, nextColumnIndex, gridRowLength - 1, gridColumnLength - 1)) {
                    continue;
                }

                if (seen[nextRowIndex][nextColumnIndex]) {
                    continue;
                }

                int extraTime = (grid[nextRowIndex][nextColumnIndex] - time) % 2 == 0 ? 1 : 0;
                int nextTime = Math.max(time + 1, grid[nextRowIndex][nextColumnIndex] + extraTime);
                queue.offer(new int[]{nextRowIndex, nextColumnIndex, nextTime});
                seen[nextRowIndex][nextColumnIndex] = true;
            }
        }

        return -1;
    }

    private boolean isInvalidIndex(
            final int rowIndex,
            final int columnIndex,
            final int lastRowIndex,
            final int lastColumnIndex
    ) {
        return rowIndex < 0 ||
                lastRowIndex < rowIndex ||
                columnIndex < 0 ||
                lastColumnIndex < columnIndex;
    }
}
