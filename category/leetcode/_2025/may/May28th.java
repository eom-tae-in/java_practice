package category.leetcode._2025.may;

import java.util.ArrayList;
import java.util.List;

public class May28th {

    public int[] maxTargetNodes(final int[][] edges1, final int[][] edges2, final int k) {
        int[] answer = new int[edges1.length + 1];
        List<Integer>[] graph1 = buildGraph(edges1);
        List<Integer>[] graph2 = buildGraph(edges2);
        int maxReachableInGraph2 = 0;

        if (k > 0) {
            for (int i = 0; i < edges2.length + 1; i++) {
                maxReachableInGraph2 = Math.max(maxReachableInGraph2, dfs(graph2, i, -1, k - 1));
            }
        }

        for (int i = 0; i < edges1.length + 1; i++) {
            answer[i] = maxReachableInGraph2 + dfs(graph1, i, -1, k);
        }

        return answer;
    }

    private int dfs(final List<Integer>[] graph, final int u, final int prev, final int k) {
        int res = 0;

        if (k == 0) {
            return 1;
        }

        for (int v : graph[u]) {
            if (v != prev) {
                res += dfs(graph, v, u, k - 1);
            }
        }
        return 1 + res;
    }

    private List<Integer>[] buildGraph(final int[][] edges) {
        List<Integer>[] graph = new ArrayList[edges.length + 1];

        for (int i = 0; i < edges.length + 1; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        return graph;
    }
}
