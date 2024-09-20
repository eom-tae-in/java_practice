package category.leetcode._2024.august;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class August29th {

    public int removeStones(final int[][] stones) {
        List<List<Integer>> graph = new ArrayList<>();
        int length = stones.length;
        int count = 0;
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (seen.add(i)) {
                dfs(graph, seen, i);
                count++;
            }
        }

        return length - count;
    }

    private void dfs(final List<List<Integer>> graph, final Set<Integer> seen, final int u) {
        for (int v : graph.get(u)) {
            if (seen.add(v)) {
                dfs(graph, seen, v);
            }
        }
    }
}
