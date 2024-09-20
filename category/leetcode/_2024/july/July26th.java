package category.leetcode._2024.july;

import java.util.Arrays;

public class July26th {

    public int findTheCity(final int n, final int[][] edges, final int distanceThreshold) {
        int minCount = Integer.MAX_VALUE;
        int answer = -1;
        int[][] graph = floydWarshall(n, edges, distanceThreshold);
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                answer = i;
            }
        }

        return answer;
    }

    private int[][] floydWarshall(final int n, final int[][] edges, final int distanceThreshold) {
        int[][] graph = new int[n][n];
        Arrays.stream(graph).forEach(row -> Arrays.fill(row, distanceThreshold + 1));
        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            graph[u][v] = weight;
            graph[v][u] = weight;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        return graph;
    }
}
