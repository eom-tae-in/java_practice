package category.leetcode._2024.july;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class July28th {

    public int secondMinimum(final int n, final int[][] edges, final int time, final int change) {
        List<Integer>[] graph = new List[n + 1];
        Queue<int[]> q = new ArrayDeque<>(List.of(new int[]{1, 0}));
        int[][] minTime = new int[n + 1][2];
        Arrays.stream(minTime)
                .forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        minTime[1][0] = 0;
        for (int i = 1; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        while (!q.isEmpty()) {
            final int i = q.peek()[0];
            final int prevTime = q.poll()[1];
            final int numChangeSignal = prevTime / change;
            final int waitTime = numChangeSignal % 2 == 0 ? 0 : change - prevTime % change;
            final int newTime = prevTime + waitTime + time;
            for (final int j : graph[i]) {
                if (newTime < minTime[j][0]) {
                    minTime[j][0] = newTime;
                    q.offer(new int[]{j, newTime});
                } else if (minTime[j][0] < newTime && newTime < minTime[j][1]) {
                    if (j == n) {
                        return newTime;
                    }
                    minTime[j][1] = newTime;
                    q.offer(new int[]{j, newTime});
                }
            }
        }

        throw new IllegalArgumentException();
    }
}
