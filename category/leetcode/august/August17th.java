package category.leetcode.august;

import java.util.ArrayDeque;
import java.util.Queue;

public class August17th {
    public int[][] updateMatrix(int[][] mat) {
        final int rowLength = mat.length;
        final int columnLength = mat[0].length;
        int[] directions = {0, 1, 0, -1, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rowLength][columnLength];

        for (int i = 0; i < rowLength; ++i)
            for (int j = 0; j < columnLength; ++j)
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            final int cRow = currentPosition[0];
            final int cColumn = currentPosition[1];
            for (int i = 0; i < 4; ++i) {
                final int nRow = cRow + directions[i];
                final int nColumn = cColumn + directions[i + 1];
                if (nRow < 0 || nRow == rowLength || nColumn < 0 || nColumn == columnLength)
                    continue;
                if (visited[nRow][nColumn])
                    continue;
                mat[nRow][nColumn] = mat[cRow][cColumn] + 1;
                queue.offer(new int[] {nRow, nColumn});
                visited[nRow][nColumn] = true;
            }
        }
        return mat;
    }
}
