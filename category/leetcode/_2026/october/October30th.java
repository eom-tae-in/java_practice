package category.leetcode._2026.october;

import java.util.*;

public class October30th {

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        long[][] dist = new long[n][k + 1];

        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(state -> state[0]));
        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long cost = current[0];
            int node = (int) current[1];
            int count = (int) current[2];

            if (cost != dist[node][count]) {
                continue;
            }

            if (node == n - 1) {
                return (int) cost;
            }

            for (int[] edge : graph[node]) {
                int next = edge[0];
                int weight = edge[1];
                int nextCount = labels.charAt(node) == labels.charAt(next) ? count + 1 : 1;

                if (nextCount > k) {
                    continue;
                }

                long nextCost = cost + weight;

                if (nextCost >= dist[next][nextCount]) {
                    continue;
                }

                dist[next][nextCount] = nextCost;
                pq.offer(new long[]{nextCost, next, nextCount});
            }
        }

        return -1;
    }
}
