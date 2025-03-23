package category.leetcode._2025.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class March23rd {

    public int countPaths(final int n, final int[][] roads) {
        List<int[]>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph[u].add(new int[]{v, time});
            graph[v].add(new int[]{u, time});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        int MOD = 1_000_000_007;
        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long time = curr[0];
            int node = (int) curr[1];

            if (time > dist[node]) {
                continue;
            }

            for (int[] neighbor : graph[node]) {
                int nextNode = neighbor[0];
                long nextTime = time + neighbor[1];

                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{nextTime, nextNode});
                } else if (nextTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
