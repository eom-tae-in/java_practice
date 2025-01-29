package category.leetcode._2025.january;

public class January29th {

    public int[] findRedundantConnection(final int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (!unionFind.unionByRank(u, v)) {
                return edge;
            }
        }

        return null;
    }

    private static class UnionFind {

        private final int[] id;
        private final int[] rank;

        private UnionFind(final int n) {
            id = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                id[i] = i;
            }
        }

        private boolean unionByRank(final int u, final int v) {
            int i = find(u);
            int j = find(v);

            if (i == j) {
                return false;
            }

            if (rank[i] < rank[j]) {
                id[i] = j;
            } else if (rank[i] > rank[j]) {
                id[j] = i;
            } else {
                id[i] = j;
                ++rank[j];
            }

            return true;
        }

        private int find(final int u) {
            return id[u] == u ? u : (id[u] = find(id[u]));
        }
    }
}
