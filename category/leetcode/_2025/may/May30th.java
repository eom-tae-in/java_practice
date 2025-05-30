package category.leetcode._2025.may;

import java.util.Arrays;

public class May30th {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int max = 100_000;
        int answer = -1;
        int[] dist1 = getDist(edges, node1);
        int[] dist2 = getDist(edges, node2);

        for (int i = 0; i < edges.length; i++) {
            if (Math.min(dist1[i], dist2[i]) > -1) {
                int currentMax = Math.max(dist1[i], dist2[i]);

                if (currentMax < max) {
                    max = currentMax;
                    answer = i;
                }
            }
        }

        return answer;
    }

    private int[] getDist(int[] edges, int node) {
        int[] dist = new int[edges.length];
        Arrays.fill(dist, -1);
        int d = 0;

        while (node != -1 && dist[node] == -1) {
            dist[node] = d++;
            node = edges[node];
        }

        return dist;
    }
}
