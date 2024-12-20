package category.leetcode._2024.december;

public class December20th {

    public TreeNode reverseOddLevels(final TreeNode root) {
        dfs(root.left, root.right, true);
        return root;
    }

    private void dfs(
            final TreeNode leftNode,
            final TreeNode rightNode,
            final boolean isOddLevel
    ) {
        if (leftNode == null) {
            return;
        }

        if (isOddLevel) {
            int temp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = temp;
        }

        dfs(leftNode.left, rightNode.right, !isOddLevel);
        dfs(leftNode.right, rightNode.left, !isOddLevel);
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

        TreeNode(
                final int val,
                final TreeNode left,
                final TreeNode right
        ) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
