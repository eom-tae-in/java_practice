package category.leetcode._2025.january;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class January19th {

    public int trapRainWater(final int[][] heightMap) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = heightMap.length;
        int n = heightMap[0].length;
        int ans = 0;
        Queue<Cube> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.h));
        boolean[][] seen = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            minHeap.offer(new Cube(i, 0, heightMap[i][0]));
            minHeap.offer(new Cube(i, n - 1, heightMap[i][n - 1]));
            seen[i][0] = true;
            seen[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; ++j) {
            minHeap.offer(new Cube(0, j, heightMap[0][j]));
            minHeap.offer(new Cube(m - 1, j, heightMap[m - 1][j]));
            seen[0][j] = true;
            seen[m - 1][j] = true;
        }

        while (!minHeap.isEmpty()) {
            int i = minHeap.peek().i;
            int j = minHeap.peek().j;
            int h = minHeap.poll().h;

            for (int[] dir : dirs) {
                final int x = i + dir[0];
                final int y = j + dir[1];

                if ((x < 0 || x == m || y < 0 || y == n) || seen[x][y]) {
                    continue;
                }

                if (heightMap[x][y] < h) {
                    ans += h - heightMap[x][y];
                    minHeap.offer(new Cube(x, y, h));
                } else {
                    minHeap.offer(new Cube(x, y, heightMap[x][y]));
                }

                seen[x][y] = true;
            }
        }

        return ans;
    }

    private record Cube(
            int i,
            int j,
            int h
    ) {
    }
}
