package category.leetcode.september;

import java.util.ArrayDeque;
import java.util.Queue;

public class September17th {

    public int shortestPathLength(int[][] graph) {
        int size = graph.length;
        int target = (1 << size) - 1;
        int[][] visit = new int[size][1 << size];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            queue.offer(new int[]{i, 1 << i});
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int state = current[1];
            int dist = visit[node][state];
            if (state == target) {
                return dist;
            }
            for (int neighbor : graph[node]) {
                int newState = state | neighbor;
                if (visit[neighbor][newState] == 0) {
                    queue.offer(new int[]{neighbor, newState});
                    visit[neighbor][newState] = dist + 1;
                }
            }
        }
        return 0;
    }
}
