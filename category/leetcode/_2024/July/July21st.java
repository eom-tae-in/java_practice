package category.leetcode._2024.July;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class July21st {

    public int[][] buildMatrix(final int k, final int[][] rowConditions, final int[][] colConditions) {
        List<Integer> row = topologicalSort(rowConditions, k);
        if (row.isEmpty()) {
            return new int[][]{};
        }
        List<Integer> column = topologicalSort(colConditions, k);
        if (column.isEmpty()) {
            return new int[][]{};
        }
        int[][] answer = new int[k][k];

        for (int i = 1; i <= k; i++) {
            int rowIndex = row.indexOf(i);
            int columnIndex = column.indexOf(i);
            if (rowIndex == -1 || columnIndex == -1) {
                return new int[][]{};
            }
            answer[rowIndex][columnIndex] = i;
        }

        return answer;
    }

    private List<Integer> topologicalSort(final int[][] conditions, final int n) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] counts = new int[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph.get(u).add(v);
            counts[v]++;
        }
        for (int i = 1; i <= n; i++) {
            if (counts[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int v : graph.get(poll)) {
                if (--counts[v] == 0) {
                    queue.offer(v);
                }
            }
            sorted.add(poll);
        }

        return sorted;
    }
}
