package category.leetcode._2025.march;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class March28th {

    public int[] maxPoints(final int[][] grid, final int[] queries) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.offer(new int[]{0, 0, grid[0][0]});
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][columnLength];
        int[] dirs = {0, 1, 0, -1, 0};
        visited[0][0] = true;
        int accumulate = 0;

        int[] answer = new int[queries.length];
        for (Query query : createQueries(queries)) {
            int queryIndex = query.getIndex();
            int queryValue = query.getValue();

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int rowIndex = poll[0];
                int columnIndex = poll[1];
                int value = poll[2];

                if (value >= queryValue) {
                    queue.offer(new int[]{rowIndex, columnIndex, value});
                    break;
                }

                accumulate++;

                for (int i = 1; i < dirs.length; i++) {
                    int nextRowIndex = rowIndex + dirs[i - 1];
                    int nextColumnIndex = columnIndex + dirs[i];

                    if (nextRowIndex < 0 || rowLength <= nextRowIndex) {
                        continue;
                    }

                    if (nextColumnIndex < 0 || columnLength <= nextColumnIndex) {
                        continue;
                    }

                    if (visited[nextRowIndex][nextColumnIndex]) {
                        continue;
                    }

                    queue.offer(new int[]{nextRowIndex, nextColumnIndex, grid[nextRowIndex][nextColumnIndex]});
                    visited[nextRowIndex][nextColumnIndex] = true;
                }
            }

            answer[queryIndex] = accumulate;
        }

        return answer;
    }

    private Query[] createQueries(final int[] queries) {
        Query[] queryArr = new Query[queries.length];

        for (int i = 0; i < queries.length; i++) {
            queryArr[i] = new Query(i, queries[i]);
        }

        Arrays.sort(queryArr, Comparator.comparingInt(Query::getValue));
        return queryArr;
    }

    private static class Query {
        private final int index;
        private final int value;

        private Query(final int index, final int value) {
            this.index = index;
            this.value = value;
        }

        private int getIndex() {
            return index;
        }

        private int getValue() {
            return value;
        }
    }
}
