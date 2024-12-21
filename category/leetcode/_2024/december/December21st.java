package category.leetcode._2024.december;

import java.util.ArrayList;
import java.util.List;

public class December21st {

    private int answer = 0;

    public int maxKDivisibleComponents(
            final int n,
            final int[][] edges,
            final int[] values,
            final int k
    ) {
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

        dfs(0, -1, values, graph, k);

        return answer;
    }

    private long dfs(
            final int current,
            final int prev,
            final int[] values,
            final List<Integer>[] graph,
            final int k
    ) {
        long sum = values[current];

        for (int nextNode : graph[current]) {
            if (nextNode != prev) {
                sum += dfs(nextNode, current, values, graph, k);
            }
        }

        if (sum % k == 0) {
            answer++;
        }

        return sum;
    }
}
