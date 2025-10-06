package category.leetcode._2025.october;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class October6th {

    public int swimInWater(int[][] grid) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n = grid.length;
        int answer = grid[0][0];
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        boolean[][] seen = new boolean[n][n];
        seen[0][0] = true;

        while (!minHeap.isEmpty()) {
            int height = minHeap.peek()[0];
            int i = minHeap.peek()[1];
            int j = minHeap.poll()[2];
            answer = Math.max(answer, height);

            if (i == n - 1 && j == n - 1) {
                break;
            }

            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];

                if (x < 0 || x == n || y < 0 || y == n) {
                    continue;
                }

                if (seen[x][y]) {
                    continue;
                }

                minHeap.offer(new int[]{grid[x][y], x, y});
                seen[x][y] = true;
            }
        }

        return answer;
    }
}
