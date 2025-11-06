package category.leetcode._2025.november;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class November6th {

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c + 1);

        for (int[] connection : connections) {
            dsu.union(connection[0], connection[1]);
        }

        Map<Integer, TreeSet<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            graph.computeIfAbsent(root, key -> new TreeSet<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int status = query[0];
            int curr = query[1];
            TreeSet<Integer> set = graph.get(dsu.find(curr));

            if (status == 2) {
                set.remove(curr);
            } else {
                if (set.contains(curr)) {
                    result.add(curr);
                } else if (set.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(set.first());
                }
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private static class DSU {

        private final int[] parent;

        private DSU(int n) {
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            if (parent[x] != x) {
                return parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX <= rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }
}
