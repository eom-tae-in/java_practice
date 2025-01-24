package category.leetcode._2025.january;

import java.util.ArrayList;
import java.util.List;

public class January24th {

    private enum State {
        VISITED,
        VISITING
    }

    public List<Integer> eventualSafeNodes(final int[][] graph) {
        int graphLength = graph.length;
        List<Integer> answer = new ArrayList<>();
        State[] isVisited = new State[graphLength];

        for (int i = 0; i < graphLength; i++) {
            if (!hasCycle(i, isVisited, graph)) {
                answer.add(i);
            }
        }

        return answer;
    }

    private boolean hasCycle(final int index, final State[] state, final int[][] graph) {
        if (state[index] == State.VISITED) {
            return true;
        }

        if (state[index] == State.VISITING) {
            return false;
        }

        state[index] = State.VISITING;

        for (int num : graph[index]) {
            if (hasCycle(num, state, graph)) {
                return true;
            }
        }

        state[index] = State.VISITED;
        return false;
    }
}
