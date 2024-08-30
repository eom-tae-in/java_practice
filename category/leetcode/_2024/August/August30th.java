package category.leetcode._2024.August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class August30th {

    public int[][] modifiedGraphEdges(
            final int n,
            final int[][] edges,
            final int source,
            final int destination,
            final int target
    ) {
        int max = 2_000_000_000;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (weight == -1) {
                continue;
            }
            graph.get(u).add(new Edge(v, weight));
            graph.get(v).add(new Edge(u, weight));
        }
        int distance = dijkstra(graph, source, destination);
        if (distance < target) {
            return new int[0][];
        }
        if (distance == target) {
            for (int[] edge : edges) {
                if (edge[2] == -1) {
                    edge[2] = max;
                }
            }

            return edges;
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            if (weight != -1) {
                continue;
            }
            edges[i][2] = 1;
            graph.get(u).add(new Edge(v, 1));
            graph.get(v).add(new Edge(u, 1));
            distance = dijkstra(graph, source, destination);
            if (distance <= target) {
                edges[i][2] += target - distance;
                for (int j = i + 1; j < edges.length; j++) {
                    if (edges[j][2] == -1) {
                        edges[j][2] = max;
                    }
                }

                return edges;
            }
        }

        return new int[0][];
    }

    private int dijkstra(
            final List<List<Edge>> graph,
            final int source,
            final int destination
    ) {
        int[] dist = new int[graph.size()];
        dist[source] = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));
        queue.offer(new Edge(source, dist[source]));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int num = edge.node();
            int weight = edge.weight();
            if (weight > dist[num]) {
                continue;
            }
            for (Edge e : graph.get(num)) {
                int eNum = e.node();
                int eWeight = e.weight();
                if (weight + eWeight < dist[eNum]) {
                    dist[eNum] = weight + eWeight;
                    queue.offer(new Edge(eNum, dist[eNum]));
                }
            }
        }

        return dist[destination];
    }

    private record Edge(
            int node,
            int weight
    ) {
    }
}
