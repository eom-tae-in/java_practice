package category.leetcode._2023.october;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class October18th {

    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] graph = new List[n];
        int[] degree = new int[n];
        int[] dist = time.clone();
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] relation : relations) {
            int u = relation[0] - 1;
            int v = relation[1] - 1;
            graph[u].add(v);
            ++degree[v];
        }
        Queue<Integer> queue = IntStream.range(0, n)
                .filter(index -> degree[index] == 0)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int v : graph[cv]) {
                dist[v] = Math.max(dist[v], dist[cv] + time[v]);
                if (--degree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return Arrays.stream(dist).max().getAsInt();
    }
}
