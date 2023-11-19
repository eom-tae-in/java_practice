package category.leetcode.november;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class November11th {

    private List<NodeInfo>[] graph;

    public November11th(int n, int[][] edges) {
        graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];
        graph[u].add(new NodeInfo(v, w));
    }

    public int shortestPath(int node1, int node2) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<NodeInfo> queue = new PriorityQueue<>(Comparator.comparingInt(NodeInfo::getValue));
        dist[node1] = 0;
        queue.offer(new NodeInfo(node1, dist[node1]));

        while (!queue.isEmpty()) {
            NodeInfo poll = queue.poll();
            int u = poll.getNode();
            int d = poll.getValue();
            if (u == node2) {
                return d;
            }
            for (NodeInfo g : graph[u]) {
                int v = g.getNode();
                int w = g.getValue();
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    queue.offer(new NodeInfo(v, dist[v]));
                }
            }
        }
        return -1;
    }
}

class NodeInfo {
    private final int node;
    private final int value;

    public NodeInfo(final int node, final int value) {
        this.node = node;
        this.value = value;
    }

    public int getNode() {
        return node;
    }

    public int getValue() {
        return value;
    }
}

