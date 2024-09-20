package category.leetcode._2024.june;

import java.util.Arrays;

public class June30th {

    public int maxNumEdgesToRemove(final int n, final int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int requiredEdges = 0;
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        for (int[] edge : edges) {
            int type = edge[0];
            int element1 = edge[1] - 1;
            int element2 = edge[2] - 1;
            if (type == 3) {
                if (alice.isNotConnected(element1, element2) && bob.isNotConnected(element1, element2)) {
                    requiredEdges++;
                }
            } else if (type == 2) {
                if (bob.isNotConnected(element1, element2)) {
                    requiredEdges++;
                }
            } else {
                if (alice.isNotConnected(element1, element2)) {
                    requiredEdges++;
                }
            }
        }
        return alice.getCount() == 1 && bob.getCount() == 1 ? edges.length - requiredEdges : -1;
    }
}

class UnionFind {

    private int count;
    private final int[] id;
    private final int[] rank;

    UnionFind(final int count) {
        this.count = count;
        id = new int[count];
        rank = new int[count];

        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    int find(final int num) {
        return id[num] == num ? num : (id[num] = find(id[num]));
    }

    boolean isNotConnected(final int element1, final int element2) {
        int root1 = find(element1);
        int root2 = find(element2);
        if (root1 == root2) {
            return false;
        }

        if (rank[root1] < rank[root2]) {
            id[root1] = root2;
        } else if (rank[root1] > rank[root2]) {
            id[root2] = root1;
        } else {
            id[root1] = root2;
            rank[root2]++;
        }
        reduceCount();
        return true;
    }

    private void reduceCount() {
        count--;
    }

    int getCount() {
        return count;
    }
}
