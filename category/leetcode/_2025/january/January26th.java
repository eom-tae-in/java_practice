package category.leetcode._2025.january;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class January26th {

    private int maxCycleLength = 0;

    public int maximumInvitations(final int[] favorite) {
        int n = favorite.length;
        int sumComponentsLength = 0;
        List<Integer>[] graph = new List[n];
        int[] inDegrees = new int[n];
        int[] maxChainLength = new int[n];
        Arrays.fill(maxChainLength, 1);

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            graph[i].add(favorite[i]);
            ++inDegrees[favorite[i]];
        }

        Queue<Integer> q = IntStream.range(0, n)
                .filter(i -> inDegrees[i] == 0)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!q.isEmpty()) {
            int u = q.poll();

            for (final int v : graph[u]) {
                if (--inDegrees[v] == 0) {
                    q.offer(v);
                }

                maxChainLength[v] = Math.max(maxChainLength[v], 1 + maxChainLength[u]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (favorite[favorite[i]] == i) {
                sumComponentsLength += maxChainLength[i] + maxChainLength[favorite[i]];
            }
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        boolean[] seen = new boolean[n];
        State[] states = new State[n];

        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                findCycle(graph, i, parent, seen, states);
            }
        }

        return Math.max(sumComponentsLength / 2, maxCycleLength);
    }

    private void findCycle(
            final List<Integer>[] graph,
            final int u,
            final int[] parent,
            final boolean[] seen,
            final State[] states
    ) {
        seen[u] = true;
        states[u] = State.VISITING;

        for (int v : graph[u]) {
            if (!seen[v]) {
                parent[v] = u;
                findCycle(graph, v, parent, seen, states);
            } else if (states[v] == State.VISITING) {
                int curr = u;
                int cycleLength = 1;

                while (curr != v) {
                    curr = parent[curr];
                    cycleLength++;
                }

                maxCycleLength = Math.max(maxCycleLength, cycleLength);
            }
        }

        states[u] = State.VISITED;
    }

    private enum State {
        VISITING,
        VISITED
    }
}
