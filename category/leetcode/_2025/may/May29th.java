package category.leetcode._2025.may;

import java.util.ArrayList;
import java.util.List;

public class May29th {

    public int[] maxTargetNodes(final int[][] edges1, final int[][] edges2) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;
        List<Integer>[] graph1 = generateGraph(edges1, n1);
        List<Integer>[] graph2 = generateGraph(edges2, n2);
        boolean[] parity1 = new boolean[n1];
        boolean[] parity2 = new boolean[n2];
        int even1 = dfs(0, -1, graph1, parity1, true);
        int even2 = dfs(0, -1, graph2, parity2, true);
        int odd1 = n1 - even1;
        int odd2 = n2 - even2;
        int tree2 = Math.max(even2, odd2);
        int[] answer = new int[n1];

        for (int i = 0; i < n1; i++) {
            int tree1 = parity1[i] ? even1 : odd1;
            answer[i] = tree1 + tree2;
        }

        return answer;
    }

    private List<Integer>[] generateGraph(final int[][] edges, final int n) {
        List<Integer>[] graph = new List[n + 1];

        for (int i = 0; i < n; i++) {
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

    private int dfs(
            final int current,
            final int prev,
            final List<Integer>[] graph,
            final boolean[] parity,
            final boolean isEven
    ) {
        int result = isEven ? 1 : 0;
        parity[current] = isEven;

        for (int node : graph[current]) {
            if (node != prev) {
                result += dfs(node, current, graph, parity, !isEven);
            }
        }

        return result;
    }
}
