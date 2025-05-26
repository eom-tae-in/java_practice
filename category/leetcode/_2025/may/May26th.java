package category.leetcode._2025.may;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class May26th {

    public int largestPathValue(final String colors, final int[][] edges) {
        int n = colors.length();
        int answer = 0;
        int processed = 0;
        List<Integer>[] graph = new List[n];
        int[] inDegrees = new int[n];
        int[][] count = new int[n][26];

        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            inDegrees[v]++;
        }

        Queue<Integer> queue = IntStream.range(0, n)
                .filter(i -> inDegrees[i] == 0)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!queue.isEmpty()) {
            int out = queue.poll();
            processed++;
            answer = Math.max(answer, ++count[out][colors.charAt(out) - 'a']);

            for (int in : graph[out]) {
                for (int i = 0; i < 26; ++i) {
                    count[in][i] = Math.max(count[in][i], count[out][i]);
                }

                if (--inDegrees[in] == 0) {
                    queue.offer(in);
                }
            }
        }

        return processed == n ? answer : -1;
    }
}
