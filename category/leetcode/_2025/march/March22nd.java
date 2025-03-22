package category.leetcode._2025.march;

import java.util.HashSet;
import java.util.Set;

public class March22nd {

    public int countCompleteComponents(final int n, final int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        Set<Integer> roots = new HashSet<>();
        int answer = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            unionFind.union(u, v);
        }

        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);

            if (!roots.contains(root) && unionFind.isCompleted(root)) {
                answer++;
                roots.add(root);
            }
        }

        return answer;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;
        private final int[] nodeCount;
        private final int[] edgeCount;

        private UnionFind(final int n) {
            parent = new int[n];
            rank = new int[n];
            nodeCount = new int[n];
            edgeCount = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                nodeCount[i] = 1;
            }
        }

        private int find(final int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        private boolean isCompleted(final int x) {
            return (nodeCount[x] * (nodeCount[x] - 1)) / 2 == edgeCount[x];
        }

        private void union(final int x, final int y) {
            int rootX = find(x);
            int rootY = find(y);
            edgeCount[rootX]++;

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                edgeCount[rootX] += edgeCount[rootY];
                nodeCount[rootX] += nodeCount[rootY];
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                edgeCount[rootY] += edgeCount[rootX];
                nodeCount[rootY] += nodeCount[rootX];
            } else {
                parent[rootY] = rootX;
                edgeCount[rootX] += edgeCount[rootY];
                nodeCount[rootX] += nodeCount[rootY];
                rank[rootX]++;
            }
        }
    }
}
