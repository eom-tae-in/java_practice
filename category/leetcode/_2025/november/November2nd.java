package category.leetcode._2025.november;

public class November2nd {

    private enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    // guard == 1, wall == 2, guardedArea == -1;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int answer = 0;
        int[][] graph = new int[m][n];

        for (int[] wall : walls) {
            graph[wall[0]][wall[1]] = 2;
        }

        for (int[] guard : guards) {
            graph[guard[0]][guard[1]] = 1;
        }

        for (int[] guard : guards) {
            dfs(guard[0] - 1, guard[1], Direction.NORTH, graph);
            dfs(guard[0] + 1, guard[1], Direction.SOUTH, graph);
            dfs(guard[0], guard[1] + 1, Direction.EAST, graph);
            dfs(guard[0], guard[1] - 1, Direction.WEST, graph);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private void dfs(
            int row,
            int col,
            Direction dir,
            int[][] graph
    ) {
        if (row < 0 || row >= graph.length || col < 0 || col >= graph[0].length ||
                graph[row][col] > 0) {
            return;
        }

        graph[row][col] = -1;

        if (dir == Direction.NORTH) {
            dfs(row - 1, col, dir, graph);
        } else if (dir == Direction.SOUTH) {
            dfs(row + 1, col, dir, graph);
        } else if (dir == Direction.EAST) {
            dfs(row, col + 1, dir, graph);
        } else {
            dfs(row, col - 1, dir, graph);
        }
    }
}
