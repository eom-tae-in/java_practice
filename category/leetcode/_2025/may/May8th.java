package category.leetcode._2025.may;

import java.util.PriorityQueue;

public class May8th {

    private static final int[] DIR_X = {0, 1, 0, -1};
    private static final int[] DIR_Y = {1, 0, -1, 0};

    public int minTimeToReach(final int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] minTime = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0, 0});
        minTime[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], time = curr[2], moveStatus = curr[3];

            if (x == n - 1 && y == m - 1) {
                return time;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + DIR_X[d];
                int ny = y + DIR_Y[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int arrivalTime = Math.max(time, moveTime[nx][ny]) + (moveStatus % 2 == 1 ? 2 : 1);

                    if (arrivalTime < minTime[nx][ny]) {
                        minTime[nx][ny] = arrivalTime;
                        pq.offer(new int[]{nx, ny, arrivalTime, moveStatus + 1});
                    }
                }
            }
        }

        return -1;
    }
}
