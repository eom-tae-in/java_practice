package category.leetcode._2025.january;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class January22nd {

    public int[][] highestPeak(final int[][] isWater) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rowLength = isWater.length;
        int columnLength = isWater[0].length;
        int[][] answer = new int[rowLength][columnLength];
        Queue<int[]> queue = new LinkedList<>();
        Arrays.stream(answer)
                .forEach(row -> Arrays.fill(row, -1));

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (isWater[i][j] == 1) {
                    answer[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int depth = 1;

        while (!queue.isEmpty()) {
            int loopCount = queue.size();

            for (int i = 0; i < loopCount; i++) {
                int[] position = queue.poll();
                int currentRow = position[0];
                int currentColumn = position[1];

                for (int[] dir : dirs) {
                    int nextRow = currentRow + dir[0];
                    int nextColumn = currentColumn + dir[1];

                    if (nextRow < 0 || rowLength <= nextRow || nextColumn < 0 || columnLength <= nextColumn) {
                        continue;
                    }

                    if (answer[nextRow][nextColumn] != -1) {
                        continue;
                    }

                    answer[nextRow][nextColumn] = depth;
                    queue.offer(new int[]{nextRow, nextColumn});
                }
            }

            depth++;
        }

        return answer;
    }
}
