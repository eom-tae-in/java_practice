package category.leetcode._2024.june;

import java.util.ArrayList;
import java.util.List;

public class June29th {

    public List<List<Integer>> getAncestors(final int n, final int[][] edges) {
        List<List<Integer>> answer = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            answer.add(new ArrayList<>());
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int left = edge[0];
            int right = edge[1];
            graph.get(left).add(right);
        }

        for (int i = 0; i < n; i++) {
            dfs(graph, answer, new boolean[n], i, i);
        }

        return answer;
    }

    private void dfs(final List<List<Integer>> graph,
                     final List<List<Integer>> answer,
                     final boolean[] visited,
                     final int ancestor,
                     final int current) {
        visited[current] = true;
        for (int edge : graph.get(current)) {
            if (visited[edge]) {
                continue;
            }
            answer.get(edge).add(ancestor);
            dfs(graph, answer, visited, ancestor, edge);
        }
    }
}
