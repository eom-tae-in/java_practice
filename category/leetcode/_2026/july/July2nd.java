package category.leetcode._2026.july;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class July2nd {

    private static final int[] DIRS = {0, 1, 0, -1, 0};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rowSize = grid.size();
        int colSize = grid.get(0).size();
        int[][] best = new int[rowSize][colSize];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        best[0][0] = health - grid.get(0).get(0);

        if (best[0][0] < 1) {
            return false;
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cr = curr[0];
            int cc = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + DIRS[i];
                int nc = cc + DIRS[i + 1];

                if (nr < 0 || nr >= rowSize || nc < 0 || nc >= colSize) {
                    continue;
                }

                int nextHealth = best[cr][cc] - grid.get(nr).get(nc);

                if (nextHealth <= best[nr][nc] || nextHealth < 1) {
                    continue;
                }

                best[nr][nc] = nextHealth;
                queue.offer(new int[]{nr, nc});
            }
        }

        return best[rowSize - 1][colSize - 1] >= 1;
    }
}
