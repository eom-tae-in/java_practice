package category.leetcode._2025.april;

public class April4th {

    public TreeNode lcaDeepestLeaves(final TreeNode root) {
        return dfs(root).getTreeNode();
    }

    private LCA dfs(final TreeNode node) {
        if (node == null) {
            return new LCA(node, 0);
        }

        LCA left = dfs(node.left);
        LCA right = dfs(node.right);

        if (left.getDepth() > right.getDepth()) {
            return new LCA(left.getTreeNode(), left.getDepth() + 1);
        }

        if (left.getDepth() < right.getDepth()) {
            return new LCA(right.getTreeNode(), right.getDepth() + 1);
        }

        return new LCA(node, left.getDepth() + 1);
    }

    private static class LCA {
        private final TreeNode treeNode;
        private final int depth;

        private LCA(final TreeNode treeNode, final int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }

        private TreeNode getTreeNode() {
            return treeNode;
        }

        private int getDepth() {
            return depth;
        }
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
