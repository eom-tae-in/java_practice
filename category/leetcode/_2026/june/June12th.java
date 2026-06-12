package category.leetcode._2026.june;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class June12th {

    private static final int MOD = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        int log = 1;

        while ((1 << log) <= n) {
            log++;
        }

        List<Integer>[] graph = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] depth = new int[n + 1];
        int[][] parent = new int[log][n + 1];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph[curr]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    depth[next] = depth[curr] + 1;
                    parent[0][next] = curr;
                }
            }
        }

        for (int l = 1; l < log; l++) {
            for (int node = 1; node <= n; node++) {
                parent[l][node] = parent[l - 1][parent[l - 1][node]];
            }
        }

        long[] pow = new long[n + 1];
        pow[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow[i] = pow[i - 1] * 2 % MOD;
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < answer.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int lca = getLCA(u, v, depth, parent, log);
            int dist = depth[u] + depth[v] - 2 * depth[lca];

            if (dist == 0) {
                answer[i] = 0;
            } else {
                answer[i] = (int) pow[dist - 1];
            }
        }

        return answer;
    }

    private int getLCA(
            int u,
            int v,
            int[] depth,
            int[][] parent,
            int log
    ) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int l = 0; l < log; l++) {
            if ((diff >> l & 1) == 1) {
                u = parent[l][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int l = log - 1; l >= 0; l--) {
            if (parent[l][u] != parent[l][v]) {
                u = parent[l][u];
                v = parent[l][v];
            }
        }

        return parent[0][u];
    }
}
