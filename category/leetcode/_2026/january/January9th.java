package category.leetcode._2026.january;

public class January9th {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).treeNode;
    }

    private NodeInfo dfs(TreeNode node) {
        if (node == null) {
            return new NodeInfo(null, 0);
        }

        NodeInfo left = dfs(node.left);
        NodeInfo right = dfs(node.right);

        if (left.depth > right.depth) {
            return new NodeInfo(left.treeNode, left.depth + 1);
        }

        if (left.depth < right.depth) {
            return new NodeInfo(right.treeNode, right.depth + 1);
        }

        return new NodeInfo(node, left.depth + 1);
    }

    private static class NodeInfo {

        private final TreeNode treeNode;
        private final int depth;

        private NodeInfo(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
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
