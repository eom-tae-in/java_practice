package category.leetcode._2026.july;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class July1st {

    private static final int[] DIRS = {0, 1, 0, -1, 0};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int rowSize = grid.size();
        int colSize = grid.get(0).size();

        if (grid.get(0).get(0) == 1 || grid.get(rowSize - 1).get(colSize - 1) == 1) {
            return 0;
        }

        int[][] dist = new int[rowSize][colSize];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rowSize; i++) {
            Arrays.fill(dist[i], -1);
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + DIRS[i];
                int nc = curr[1] + DIRS[i + 1];

                if (nr < 0 || nr >= rowSize || nc < 0 || nc >= colSize) {
                    continue;
                }

                if (dist[nr][nc] != -1) {
                    continue;
                }

                dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        int left = 0;
        int right = 2 * (rowSize - 1);
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canReach(dist, mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canReach(int[][] dist, int limit) {
        int rowLen = dist.length;
        int colLen = dist[0].length;

        if (dist[0][0] < limit || dist[rowLen - 1][colLen - 1] < limit) {
            return false;
        }

        boolean[][] visited = new boolean[rowLen][colLen];
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[0] == rowLen - 1 && curr[1] == colLen - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + DIRS[i];
                int nc = curr[1] + DIRS[i + 1];

                if (nr < 0 || nr >= rowLen || nc < 0 || nc >= colLen) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (dist[nr][nc] < limit) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }

        return false;
    }
}
