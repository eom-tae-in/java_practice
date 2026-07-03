package category.leetcode._2026.july;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class July3rd {

    private List<int[]>[] graph;
    private int[] topo;
    private boolean[] online;
    private long k;
    private int n;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.online = online;
        this.k = k;
        this.n = online.length;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        int high = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], cost = e[2];
            graph[u].add(new int[]{v, cost});
            indegree[v]++;
            high = Math.max(high, cost);
        }

        topo = getTopoOrder(indegree);

        int left = 0;
        int right = high;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canReach(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private int[] getTopoOrder(int[] indegree) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[n];
        int idx = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[idx++] = curr;

            for (int[] next : graph[curr]) {
                int v = next[0];
                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return order;
    }

    private boolean canReach(int minScore) {
        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == INF || !online[u]) {
                continue;
            }

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int cost = edge[1];

                if (!online[v] || cost < minScore) {
                    continue;
                }

                long nextCost = dist[u] + cost;

                if (nextCost < dist[v] && nextCost <= k) {
                    dist[v] = nextCost;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}
