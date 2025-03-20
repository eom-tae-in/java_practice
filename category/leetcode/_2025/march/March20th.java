package category.leetcode._2025.march;

import java.util.Arrays;

public class March20th {

    public int[] minimumCost(final int n, final int[][] edges, final int[][] query) {
        int queryLength = query.length;
        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            unionFind.unionWithWeight(u, v, w);
        }

        int[] answer = new int[queryLength];

        for (int i = 0; i < queryLength; i++) {
            int start = query[i][0];
            int end = query[i][1];
            answer[i] = unionFind.getMinCost(start, end);
        }

        return answer;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;
        private final int[] weight;

        private UnionFind(final int n) {
            parent = new int[n];
            rank = new int[n];
            weight = new int[n];
            Arrays.fill(weight, Integer.MAX_VALUE);

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(final int i) {
            if (i != parent[i]) {
                parent[i] = find(parent[i]);
            }

            return parent[i];
        }

        private void unionWithWeight(final int x, final int y, final int w) {
            int rootX = find(x);
            int rootY = find(y);
            int newWeight = weight[rootX] & weight[rootY] & w;
            weight[rootX] = newWeight;
            weight[rootY] = newWeight;

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }

        private int getMinCost(final int x, final int y) {
            int rootY = find(y);
            int rootX = find(x);

            return rootX == rootY ? weight[rootX] : -1;
        }
    }
}
