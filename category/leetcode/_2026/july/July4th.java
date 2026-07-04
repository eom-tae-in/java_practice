package category.leetcode._2026.july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class July4th {

    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int dist = road[2];
            graph[a].add(new int[]{b, dist});
            graph[b].add(new int[]{a, dist});
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int[] next : graph[curr]) {
                int nextCity = next[0];
                int dist = next[1];
                answer = Math.min(answer, dist);

                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }

        return answer;
    }
}
