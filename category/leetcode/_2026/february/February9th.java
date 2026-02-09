package category.leetcode._2026.february;

import java.util.ArrayList;
import java.util.List;

public class February9th {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        collectInorder(root, nodes);

        return makeBalanceBST(0, nodes.size() - 1, nodes);
    }

    private void collectInorder(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }

        collectInorder(node.left, nodes);
        nodes.add(node.val);
        collectInorder(node.right, nodes);
    }

    private TreeNode makeBalanceBST(int left, int right, List<Integer> nodes) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        return new TreeNode(
                nodes.get(mid),
                makeBalanceBST(left, mid - 1, nodes),
                makeBalanceBST(mid + 1, right, nodes)
        );
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
