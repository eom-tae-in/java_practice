package category.leetcode._2026.february;

public class February24th {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int curr) {
        if (node == null) {
            return 0;
        }

        curr = 2 * curr + node.val;

        if (node.left == null && node.right == null) {
            return curr;
        }

        return dfs(node.left, curr) + dfs(node.right, curr);
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
