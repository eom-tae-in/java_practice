package category.leetcode._2024.june;

public class June25th {

    private int sum = 0;

    public TreeNode bstToGst(final TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = bstToGst(root.right);
        sum += root.val;
        TreeNode current = new TreeNode(sum);
        TreeNode left = bstToGst(root.left);
        current.left = left;
        current.right = right;

        return current;
    }
}

class TreeNode {

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
