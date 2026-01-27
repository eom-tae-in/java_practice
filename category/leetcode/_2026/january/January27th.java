package category.leetcode._2026.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class January27th {

    public int minCost(int n, int[][] edges) {
        List<Edge>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, 2 * w));
        }

        long inf = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, inf);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long d = cur[1];

            if (d > dist[u]) {
                continue;
            }

            for (Edge e : graph[u]) {
                int v = e.to;
                long nd = d + e.cost;

                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{v, nd});
                }
            }
        }

        return dist[n - 1] == inf ? -1 : (int) dist[n - 1];
    }

    private static class Edge {
        private final int to;
        private final int cost;

        private Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
