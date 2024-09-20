package category.leetcode._2024.may;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class May15th {

    private final int[] dy = {0, 1, 0, -1};
    private final int[] dx = {1, 0, -1, 0};

    public int maximumSafenessFactor(final List<List<Integer>> grid) {
        int[][] thiefDistance = getThiefDistance(grid);

        return bfs(thiefDistance);
    }

    private int[][] getThiefDistance(final List<List<Integer>> grid) {
        int n = grid.size();
        Queue<Position> queue = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[n][n];
        int[][] thiefDistance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.offer(Position.createWith(i, j));
                    isVisited[i][j] = true;
                }
            }
        }

        int counter = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position position = queue.poll();
                int y = position.getY();
                int x = position.getX();
                thiefDistance[y][x] = counter;
                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if (isExistPosition(ny, nx, n) && !isVisited[ny][nx]) {
                        queue.offer(Position.createWith(ny, nx));
                        isVisited[ny][nx] = true;
                    }
                }
            }
            counter++;
        }

        return thiefDistance;
    }

    private boolean isExistPosition(final int y, final int x, final int n) {
        return y >= 0 && x >= 0 && y < n && x < n;
    }

    private int bfs(final int[][] thiefDistance) {
        int n = thiefDistance.length;
        Queue<Position> queue = new PriorityQueue<>(Comparator.comparing(Position::getDistance).reversed());
        boolean[][] isVisited = new boolean[n][n];
        queue.offer(Position.createWith(0, 0, thiefDistance[0][0]));
        isVisited[0][0] = true;
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int y = position.getY();
            int x = position.getX();
            if (y == n - 1 && x == n - 1) {
                return position.getDistance();
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (isExistPosition(ny, nx, n) && !isVisited[ny][nx] && thiefDistance[ny][nx] != 0) {
                    int dist = Math.min(thiefDistance[ny][nx], position.getDistance());
                    queue.offer(Position.createWith(ny, nx, dist));
                    isVisited[ny][nx] = true;
                }
            }
        }

        return 0;
    }
}


class Position {
    private final int y;
    private final int x;
    private final int distance;

    private Position(final int y, final int x, final int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }

    static Position createWith(final int y, final int x) {
        return new Position(y, x, 0);
    }

    static Position createWith(final int y, final int x, final int distance) {
        return new Position(y, x, distance);
    }

    int getY() {
        return y;
    }

    int getX() {
        return x;
    }

    int getDistance() {
        return distance;
    }
}
