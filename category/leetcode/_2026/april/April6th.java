package category.leetcode._2026.april;

import java.util.HashSet;
import java.util.Set;

public class April6th {

    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        int answer = 0;
        int d = 0;
        int x = 0;
        int y = 0;
        Set<String> obstaclesSet = new HashSet<>();

        for (int[] o : obstacles) {
            obstaclesSet.add(o[0] + "," + o[1]);
        }

        for (int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
            } else if (c == -2) {
                d = (d + 3) % 4;
            } else {
                for (int step = 0; step < c; ++step) {
                    int nextX = x + DIRS[d][0];
                    int nextY = y + DIRS[d][1];

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
