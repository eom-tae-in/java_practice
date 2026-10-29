package category.leetcode._2026.october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class October29th {

    private int n;
    private int log;
    private int[] first;
    private int[] to;
    private int[] next;
    private int edgeCount;
    private int[][] parent;
    private int[] depth;
    private int[] tin;
    private int[] tout;
    private int[] initialMask;
    private int[] currentBit;
    private int[] fenwick;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        log = 32 - Integer.numberOfLeadingZeros(n);
        first = new int[n];
        Arrays.fill(first, -1);
        to = new int[edges.length * 2];
        next = new int[edges.length * 2];
        edgeCount = 0;

        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
            addEdge(edge[1], edge[0]);
        }

        parent = new int[log][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        initialMask = new int[n];
        currentBit = new int[n];
        fenwick = new int[n + 1];

        for (int i = 0; i < n; i++) {
            currentBit[i] = 1 << (s.charAt(i) - 'a');
        }

        build();
        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            boolean update = query.charAt(0) == 'u';
            int index = update ? 7 : 6;
            int u = 0;

            while (query.charAt(index) != ' ') {
                u = u * 10 + query.charAt(index++) - '0';
            }

            index++;

            if (update) {
                int newBit = 1 << (query.charAt(index) - 'a');
                int delta = currentBit[u] ^ newBit;

                if (delta != 0) {
                    add(tin[u], delta);
                    add(tout[u] + 1, delta);
                    currentBit[u] = newBit;
                }
            } else {
                int v = 0;

                while (index < query.length()) {
                    v = v * 10 + query.charAt(index++) - '0';
                }

                int mask = initialMask[u] ^ initialMask[v] ^ prefixXor(tin[u]) ^ prefixXor(tin[v]) ^ currentBit[lca(u, v)];
                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    private void addEdge(int u, int v) {
        to[edgeCount] = v;
        next[edgeCount] = first[u];
        first[u] = edgeCount++;
    }

    private void build() {
        int[] stack = new int[n];
        int[] order = new int[n];
        int top = 0;
        int timer = 0;
        stack[top++] = 0;

        while (top > 0) {
            int u = stack[--top];
            order[timer] = u;
            tin[u] = ++timer;
            tout[u] = tin[u];
            initialMask[u] = currentBit[u];

            if (u != 0) {
                initialMask[u] ^= initialMask[parent[0][u]];
            }

            for (int k = 1; k < log; k++) {
                parent[k][u] = parent[k - 1][parent[k - 1][u]];
            }

            for (int e = first[u]; e != -1; e = next[e]) {
                int v = to[e];

                if (v == parent[0][u]) {
                    continue;
                }

                parent[0][v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            int p = parent[0][u];
            tout[p] = Math.max(tout[p], tout[u]);
        }
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        while (diff != 0) {
            int k = Integer.numberOfTrailingZeros(diff);
            u = parent[k][u];
            diff &= diff - 1;
        }

        if (u == v) {
            return u;
        }

        for (int k = log - 1; k >= 0; k--) {
            if (parent[k][u] != parent[k][v]) {
                u = parent[k][u];
                v = parent[k][v];
            }
        }

        return parent[0][u];
    }

    private void add(int index, int value) {
        while (index <= n) {
            fenwick[index] ^= value;
            index += index & -index;
        }
    }

    private int prefixXor(int index) {
        int result = 0;

        while (index > 0) {
            result ^= fenwick[index];
            index -= index & -index;
        }

        return result;
    }
}
