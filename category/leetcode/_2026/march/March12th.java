package category.leetcode._2026.march;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class March12th {

    public int maxStability(int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);
        int answer = Integer.MAX_VALUE;
        int cnt = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            int type = e[3];

            if (type == 1) {
                int pu = dsu.find(u);
                int pv = dsu.find(v);

                if (pu == pv) {
                    return -1;
                }

                dsu.union(u, v);
                answer = Math.min(answer, wt);
                cnt++;

            } else {
                pq.add(e);
            }
        }

        List<Integer> weak = new ArrayList<>();

        while (!pq.isEmpty() && cnt < n - 1) {
            int[] e = pq.poll();
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            int pu = dsu.find(u);
            int pv = dsu.find(v);

            if (pu == pv) {
                continue;
            }

            dsu.union(u, v);
            weak.add(wt);
            cnt++;
        }

        int root = dsu.find(0);

        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != root) {
                return -1;
            }
        }

        for (int i = weak.size() - 1; i >= 0; i--) {
            int wt = weak.get(i);

            if (k > 0) {
                answer = Math.min(answer, 2 * wt);
                k--;
            } else {
                answer = Math.min(answer, wt);
            }
        }

        return answer;
    }

    private static class DSU {

        private final int[] par;
        private final int[] size;

        private DSU(int n) {
            par = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                par[i] = i;
                size[i] = 1;
            }
        }

        private int find(int x) {
            if (par[x] == x) {
                return x;
            }

            return par[x] = find(par[x]);
        }

        private void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) {
                return;
            }

            if (size[pa] >= size[pb]) {
                par[pb] = pa;
                size[pa] += size[pb];
            } else {
                par[pa] = pb;
                size[pb] += size[pa];
            }
        }
    }
}
