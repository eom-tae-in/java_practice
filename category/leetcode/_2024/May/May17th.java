package category.leetcode._2024.May;

public class May17th {

    public TreeNode removeLeafNodes(final TreeNode root, final int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        return isLeafNode(root) && root.val == target ? null : root;
    }

    private boolean isLeafNode(final TreeNode root) {
        return root.left == null && root.right == null;
    }
}
