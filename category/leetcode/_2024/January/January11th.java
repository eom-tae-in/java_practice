package category.leetcode._2024.January;

public class January11th {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, final int min, final int max) {
        if (root == null) {
            return 0;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        final int l = dfs(root.left, min, max);
        final int r = dfs(root.right, min, max);
        return Math.max(max - min, Math.max(l, r));
    }
}
