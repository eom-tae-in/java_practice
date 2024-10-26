package category.leetcode._2024.october;

import java.util.HashMap;
import java.util.Map;

public class October26th {

    private final Map<Integer, Integer> valueDepthMap = new HashMap<>();
    private final Map<Integer, Integer> valueMaxDepthMap = new HashMap<>();

    public int[] treeQueries(final TreeNode root, final int[] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        dfs(root, 0, 0);

        for (int i = 0; i < n; i++) {
            answer[i] = valueMaxDepthMap.get(queries[i]);
        }

        return answer;
    }

    private void dfs(final TreeNode node, final int depth, final int maxDepth) {
        if (node == null) {
            return;
        }
        valueMaxDepthMap.put(node.val, maxDepth);

        dfs(node.left, depth + 1, Math.max(maxDepth, depth + getDepth(node.right)));
        dfs(node.right, depth + 1, Math.max(maxDepth, depth + getDepth(node.left)));
    }

    private int getDepth(final TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (valueDepthMap.containsKey(node.val)) {
            return valueDepthMap.get(node.val);
        }

        int depth = 1 + Math.max(getDepth(node.left), getDepth(node.right));
        valueDepthMap.put(node.val, depth);

        return depth;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(final int val) {
            this.val = val;
        }

        TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
