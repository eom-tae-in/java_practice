package category.leetcode._2025.february;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class February21st {

    private static class FindElements {

        private final Set<Integer> set;

        public FindElements(final TreeNode root) {
            set = new HashSet<>();

            if (root == null) {
                return;
            }

            root.val = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    set.add(treeNode.val);

                    if (treeNode.left != null) {
                        treeNode.left.val = treeNode.val * 2 + 1;
                        queue.offer(treeNode.left);
                    }

                    if (treeNode.right != null) {
                        treeNode.right.val = treeNode.val * 2 + 2;
                        queue.offer(treeNode.right);
                    }
                }
            }
        }

        public boolean find(final int target) {
            return set.contains(target);
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
