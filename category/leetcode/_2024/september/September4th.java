package category.leetcode._2024.september;

import java.util.HashSet;
import java.util.Set;

public class September4th {

    public int robotSim(final int[] commands, final int[][] obstacles) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int answer = 0;
        int d = 0;
        int x = 0;
        int y = 0;
        Set<String> obstaclesSet = new HashSet<>();
        for (int[] o : obstacles) {
            obstaclesSet.add(o[0] + "," + o[1]);
        }
        for (final int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
            } else if (c == -2) {
                d = (d + 3) % 4;
            } else {
                for (int step = 0; step < c; ++step) {
                    int nextX = x + dirs[d][0];
                    int nextY = y + dirs[d][1];
                    if (obstaclesSet.contains(nextX + "," + nextY)) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                }
            }
            answer = Math.max(answer, x * x + y * y);
        }

        return answer;
    }
}
