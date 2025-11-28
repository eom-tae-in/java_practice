package category.leetcode._2025.november;

import java.util.ArrayList;
import java.util.List;

public class November28th {

    private int answer = 0;

    public int maxKDivisibleComponents(
            int n, int[][] edges, int[] values, int k) {
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

        dfs(0, -1, k, values, graph);

        return answer;
    }

    private long dfs(int idx, int prevIdx, int k, int[] values, List<Integer>[] graph) {
        long sum = values[idx];

        for (int nextIdx : graph[idx]) {
            if (nextIdx != prevIdx) {
                sum += dfs(nextIdx, idx, k, values, graph);
            }
        }

        if (sum % k == 0) {
            answer++;
        }

        return sum;
    }
}
