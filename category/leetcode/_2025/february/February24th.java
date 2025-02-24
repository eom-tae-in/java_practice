package category.leetcode._2025.february;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class February24th {

    public int mostProfitablePath(
            final int[][] edges,
            final int bob,
            final int[] amount
    ) {
        int n = amount.length;
        List<Integer>[] tree = new List[n];
        int[] parent = new int[n];
        int[] aliceDist = new int[n];
        Arrays.fill(aliceDist, -1);

        for (int i = 0; i < n; ++i) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(tree, 0, -1, 0, parent, aliceDist);

        for (int u = bob, bobDist = 0; u != 0; u = parent[u], ++bobDist) {
            if (bobDist < aliceDist[u]) {
                amount[u] = 0;
            } else if (bobDist == aliceDist[u]) {
                amount[u] /= 2;
            }
        }

        return getMoney(tree, 0, -1, amount);
    }

    private void dfs(
            final List<Integer>[] tree,
            final int u,
            final int prev,
            final int d,
            final int[] parent,
            final int[] dist
    ) {
        parent[u] = prev;
        dist[u] = d;

        for (int v : tree[u]) {
            if (dist[v] == -1) {
                dfs(tree, v, u, d + 1, parent, dist);
            }
        }
    }

    private int getMoney(
            final List<Integer>[] tree,
            final int u,
            final int prev,
            final int[] amount
    ) {
        if (tree[u].size() == 1 && tree[u].get(0) == prev) {
            return amount[u];
        }

        int maxPath = Integer.MIN_VALUE;

        for (int v : tree[u]) {
            if (v != prev) {
                maxPath = Math.max(maxPath, getMoney(tree, v, u, amount));
            }
        }

        return amount[u] + maxPath;
    }
}
