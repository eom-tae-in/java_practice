package category.leetcode._2026.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class May30th {

    public List<Boolean> getResults(int[][] queries) {
        int n = Math.min(50000, queries.length * 3);
        List<Boolean> answer = new ArrayList<>();
        FenwickTree tree = new FenwickTree(n + 1);
        TreeSet<Integer> obstacles = new TreeSet<>(Arrays.asList(0, n));

        for (int[] query : queries) {
            int type = query[0];

            if (type == 1) {
                int x = query[1];
                obstacles.add(x);
            }
        }

        Iterator<Integer> it = obstacles.iterator();
        int x1 = it.next();

        while (it.hasNext()) {
            int x2 = it.next();
            tree.add(x2, x2 - x1);
            x1 = x2;
        }

        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int x = queries[i][1];
            if (type == 1) {
                Integer next = obstacles.higher(x);
                Integer prev = obstacles.lower(x);

                if (next != null) {
                    tree.add(next, next - prev);
                }

                obstacles.remove(x);
            } else {
                int sz = queries[i][2];
                int prev = obstacles.floor(x);
                answer.add(tree.get(prev) >= sz || x - prev >= sz);
            }
        }

        Collections.reverse(answer);

        return answer;
    }

    private static class FenwickTree {

        private final int[] vals;

        private FenwickTree(int n) {
            vals = new int[n + 1];
        }

        private void add(int i, int val) {
            while (i < vals.length) {
                vals[i] = Math.max(vals[i], val);
                i += lowbit(i);
            }
        }

        private int get(int i) {
            int res = 0;

            while (i > 0) {
                res = Math.max(res, vals[i]);
                i -= lowbit(i);
            }

            return res;
        }

        private static int lowbit(int i) {
            return i & -i;
        }
    }
}
