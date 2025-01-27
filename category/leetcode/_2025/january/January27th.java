package category.leetcode._2025.january;

import java.util.ArrayList;
import java.util.List;

public class January27th {

    public List<Boolean> checkIfPrerequisite(
            final int numCourses,
            final int[][] prerequisites,
            final int[][] queries
    ) {
        List<Integer>[] graph = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] request : prerequisites) {
            graph[request[0]].add(request[1]);
        }

        boolean[][] isVisited = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            dfs(i, isVisited[i], graph);
        }

        List<Boolean> answer = new ArrayList<>();

        for (int[] query : queries) {
            answer.add(isVisited[query[0]][query[1]]);
        }

        return answer;
    }

    private void dfs(
            final int index,
            final boolean[] isVisited,
            final List<Integer>[] graph
    ) {
        for (int node : graph[index]) {
            if (isVisited[node]) {
                continue;
            }

            isVisited[node] = true;
            dfs(node, isVisited, graph);
        }
    }
}
