package category.leetcode._2026.august;

import java.util.ArrayList;
import java.util.List;

public class August5th {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];
            graph[u].add(v);
        }

        boolean[] isTarget = new boolean[n];
        dfs(k, isTarget, graph);

        for (int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];

            if (!isTarget[u] && isTarget[v]) {
                List<Integer> answer = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    answer.add(i);
                }

                return answer;
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!isTarget[i]) {
                answer.add(i);
            }
        }

        return answer;
    }

    private void dfs(
            int idx,
            boolean[] isTarget,
            List<Integer>[] graph
    ) {
        isTarget[idx] = true;

        for (int next : graph[idx]) {
            if (!isTarget[next]) {
                dfs(next, isTarget, graph);
            }
        }
    }
}
