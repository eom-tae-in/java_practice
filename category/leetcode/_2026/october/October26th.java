package category.leetcode._2026.october;

import java.util.ArrayDeque;
import java.util.Queue;

public class October26th {

    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<Integer> queue = new ArrayDeque<>();
        int answer = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }

                long sum = grid[r][c];
                grid[r][c] = 0;
                queue.offer(r * cols + c);

                while (!queue.isEmpty()) {
                    int position = queue.poll();
                    int currentR = position / cols;
                    int currentC = position % cols;

                    for (int d = 0; d < 4; d++) {
                        int nextR = currentR + dr[d];
                        int nextC = currentC + dc[d];

                        if (nextR < 0 || nextR >= rows || nextC < 0 || nextC >= cols || grid[nextR][nextC] == 0) {
                            continue;
                        }

                        sum += grid[nextR][nextC];
                        grid[nextR][nextC] = 0;
                        queue.offer(nextR * cols + nextC);
                    }
                }

                if (sum % k == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
