package category.leetcode._2024.november;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class November30th {

    public int[][] validArrangement(final int[][] pairs) {
        List<int[]> answer = new ArrayList<>();
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            graph.putIfAbsent(start, new ArrayDeque<>());
            graph.get(start).push(end);
            outDegree.merge(start, 1, Integer::sum);
            inDegrees.merge(end, 1, Integer::sum);
        }

        int startNode = getStartNode(graph, outDegree, inDegrees, pairs);
        euler(graph, startNode, answer);
        Collections.reverse(answer);

        return answer.stream().toArray(int[][]::new);
    }

    private int getStartNode(
            final Map<Integer, Deque<Integer>> graph,
            final Map<Integer, Integer> outDegree,
            final Map<Integer, Integer> inDegrees,
            final int[][] pairs
    ) {
        for (int u : graph.keySet()) {
            if (outDegree.getOrDefault(u, 0) - inDegrees.getOrDefault(u, 0) == 1) {
                return u;
            }
        }

        return pairs[0][0];
    }

    private void euler(
            final Map<Integer, Deque<Integer>> graph,
            final int u,
            final List<int[]> answer
    ) {
        Deque<Integer> stack = graph.get(u);

        while (stack != null && !stack.isEmpty()) {
            int v = stack.pop();
            euler(graph, v, answer);
            answer.add(new int[]{u, v});
        }
    }
}
