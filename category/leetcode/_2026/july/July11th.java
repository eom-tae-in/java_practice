package category.leetcode._2026.july;

import java.util.ArrayList;
import java.util.List;

public class July11th {

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            SubGraph subGraph = new SubGraph();
            dfs(i, subGraph, visited, graph);

            if (isConnected(subGraph)) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int idx, SubGraph subGraph, boolean[] visited, List<Integer>[] graph) {
        visited[idx] = true;
        subGraph.edge += graph[idx].size();
        subGraph.vertex++;

        for (int next : graph[idx]) {
            if (!visited[next]) {
                dfs(next, subGraph, visited, graph);
            }
        }
    }

    private boolean isConnected(SubGraph subGraph) {
        int n = subGraph.vertex;

        return subGraph.edge / 2 == n * (n - 1) / 2;
    }

    private static class SubGraph {

        private int edge;
        private int vertex;

        private SubGraph() {
            edge = 0;
            vertex = 0;
        }
    }
}
