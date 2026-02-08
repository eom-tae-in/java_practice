package category.leetcode._2026.february;

public class February8th {

    public boolean isBalanced(TreeNode root) {
        return calculateDepth(root) != -1;
    }

    private int calculateDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = calculateDepth(root.left);

        if (left == -1) {
            return -1;
        }

        int right = calculateDepth(root.right);

        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
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
