package category.leetcode._2025.december;

import java.util.ArrayList;
import java.util.List;

public class December19th {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        DSU dsu = new DSU(n, firstPerson);
        int maxTime = 0;

        for (int[] meeting : meetings) {
            maxTime = Math.max(maxTime, meeting[2]);
        }

        List<int[]>[] graph = new List[maxTime + 1];

        for (int[] meeting : meetings) {
            int u = meeting[0];
            int v = meeting[1];
            int time = meeting[2];

            if (graph[time] == null) {
                graph[time] = new ArrayList<>();
            }

            graph[time].add(new int[]{u, v});
        }

        for (int time = 1; time <= maxTime; time++) {
            List<int[]> curr = graph[time];

            if (curr == null) {
                continue;
            }

            for (int[] value : curr) {
                dsu.union(value[0], value[1]);
            }

            for (int[] value : curr) {
                int u = value[0];
                int v = value[1];

                if (dsu.find(u) != 0) {
                    dsu.reset(u);
                }

                if (dsu.find(v) != 0) {
                    dsu.reset(v);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == 0) {
                answer.add(i);
            }
        }

        return answer;
    }

    private static class DSU {

        private final int[] parent;

        private DSU(int n, int firstPerson) {
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            parent[firstPerson] = 0;
        }

        private int find(int x) {
            if (parent[x] == x) {
                return parent[x];
            }

            return parent[x] = find(parent[x]);
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX > rootY) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }
        }

        private void reset(int x) {
            parent[x] = x;
        }
    }
}
