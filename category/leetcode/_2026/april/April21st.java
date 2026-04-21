package category.leetcode._2026.april;

import java.util.HashMap;
import java.util.Map;

public class April21st {

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int answer = 0;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer>[] groupIdToCount = new Map[n];

        for (int i = 0; i < n; i++) {
            groupIdToCount[i] = new HashMap<>();
        }

        for (int[] allowedSwap : allowedSwaps) {
            uf.union(allowedSwap[0], allowedSwap[1]);
        }

        for (int i = 0; i < n; i++) {
            groupIdToCount[uf.find(i)].merge(source[i], 1, Integer::sum);
        }

        for (int i = 0; i < n; i++) {
            int groupId = uf.find(i);
            Map<Integer, Integer> count = groupIdToCount[groupId];

            if (!count.containsKey(target[i])) {
                answer++;
            } else if (count.merge(target[i], -1, Integer::sum) == 0) {
                count.remove(target[i]);
            }
        }

        return answer;
    }

    private static class UnionFind {

        private final int[] parent;
        private final int[] rank;

        private UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }
}
