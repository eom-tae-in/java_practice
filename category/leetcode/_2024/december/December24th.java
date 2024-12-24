package category.leetcode._2024.december;

import java.util.ArrayList;
import java.util.List;

public class December24th {

    public int minimumDiameterAfterMerge(final int[][] edges1, final int[][] edges2) {
        int edges1Diameter = getDiameter(edges1);
        int edges2Diameter = getDiameter(edges2);
        int combinedDiameter = (edges1Diameter + 1) / 2 + (edges2Diameter + 1) / 2 + 1;

        return Math.max(Math.max(edges1Diameter, edges2Diameter), combinedDiameter);
    }

    private int getDiameter(final int[][] edges) {
        int graphLength = edges.length + 1;
        List<Integer>[] graph = new List[graphLength];

        for (int i = 0; i < graphLength; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] maxValue = new int[1];
        dfs(0, -1, maxValue, graph);

        return maxValue[0];
    }

    private int dfs(
            final int currentNode,
            final int prevNode,
            final int[] maxValue,
            final List<Integer>[] graph
    ) {
        int primaryDiameter = 0;
        int secondaryDiameter = 0;

        for (int nextNode : graph[currentNode]) {
            if (nextNode == prevNode) {
                continue;
            }

            int diameter = dfs(nextNode, currentNode, maxValue, graph);
            if (diameter > primaryDiameter) {
                secondaryDiameter = primaryDiameter;
                primaryDiameter = diameter;
            } else if (diameter > secondaryDiameter) {
                secondaryDiameter = diameter;
            }
        }

        maxValue[0] = Math.max(maxValue[0], primaryDiameter + secondaryDiameter);
        return primaryDiameter + 1;
    }
}
