package category.leetcode._2026.november;

import java.util.*;

public class November21st {

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> children = new ArrayList<>(n);

        for (int node = 0; node < n; node++) {
            children.add(new ArrayList<>());
        }

        for (int node = 1; node < n; node++) {
            children.get(parent[node]).add(node);
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);
        int[] previousSame = new int[n];
        int[] size = new int[n];
        Arrays.fill(size, 1);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int event = stack.pop();

            if (event >= 0) {
                int node = event;
                int c = s.charAt(node) - 'a';
                previousSame[node] = last[c];
                last[c] = node;
                stack.push(-node - 1);

                for (int child : children.get(node)) {
                    stack.push(child);
                }

            } else {
                int node = -event - 1;
                int c = s.charAt(node) - 'a';
                last[c] = previousSame[node];
                int finalParent = previousSame[node];

                if (finalParent == -1) {
                    finalParent = parent[node];
                }

                if (finalParent != -1) {
                    size[finalParent] += size[node];
                }
            }
        }

        return size;
    }
}
