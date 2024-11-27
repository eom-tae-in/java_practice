package category.leetcode._2024.november;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class November27th {

    public int[] shortestDistanceAfterQueries(
            final int[][] queries,
            final int n
    ) {
        List<Integer>[] graph = new List[n];
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = i;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            graph[i].add(i + 1);
        }

        int queryLength = queries.length;
        int[] answer = new int[queryLength];

        for (int i = 0; i < queryLength; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph[u].add(v);

            if (dist[u] + 1 < dist[v]) {
                dist[v] = dist[u] + 1;
                applyShortPath(graph, dist, v);
            }

            answer[i] = dist[n - 1];
        }

        return answer;
    }

    private void applyShortPath(
            final List<Integer>[] graph,
            final int[] dist,
            final int start
    ) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph[u]) {
                if (dist[u] + 1 < dist[v]) {
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                }
            }
        }
    }
}
