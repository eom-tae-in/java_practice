package category.leetcode.september.sixteenth;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Element {
    int row;
    int column;
    int effort;

    public Element(int row, int column, int effort) {
        this.row = row;
        this.column = column;
        this.effort = effort;
    }
}

public class BFS {

    public int minimumEffortPath(int[][] heights) {
        int rowSize = heights.length;
        int columnSize = heights[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        Queue<Element> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.effort));
        int[][] efforts = new int[rowSize][columnSize];
        Arrays.stream(efforts)
                .forEach(rows -> Arrays.fill(rows, Integer.MAX_VALUE));
        boolean[][] visit = new boolean[rowSize][columnSize];
        queue.offer(new Element(0, 0, 0));
        efforts[0][0] = 0;

        while (!queue.isEmpty()) {
            Element element = queue.poll();
            int cRow = element.row;
            int cColumn = element.column;
            int cEffort = element.effort;
            visit[cRow][cColumn] = true;
            if (cRow == rowSize - 1 && cColumn == columnSize - 1) {
                return cEffort;
            }
            for (int i = 0; i < 4; i++) {
                int nRow = cRow + dirs[i];
                int nColumn = cColumn + dirs[i + 1];
                if (nRow < 0 || nColumn < 0 || nRow >= rowSize || nColumn >= columnSize) {
                    continue;
                }
                if (visit[nRow][nColumn]) {
                    continue;
                }
                int nextEffort = Math.abs(heights[cRow][cColumn] - heights[nRow][nColumn]);
                int maxEffort = Math.max(nextEffort, cEffort);
                if (efforts[nRow][nColumn] > maxEffort) {
                    efforts[nRow][nColumn] = maxEffort;
                    queue.offer(new Element(nRow, nColumn, maxEffort));
                }
            }
        }
        return 0;
    }
}

