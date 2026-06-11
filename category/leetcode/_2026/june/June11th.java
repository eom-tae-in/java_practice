package category.leetcode._2026.june;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class June11th {

    private static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new List[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        long depth = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int next : graph[curr]) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }

            depth++;
        }

        if (depth == 0) {
            return 0;
        }

        return (int) modPow(2, depth - 1);
    }

    private long modPow(long base, long exp) {
        long num = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                num = num * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return num;
    }
}
