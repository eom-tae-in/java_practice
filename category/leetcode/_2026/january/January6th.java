package category.leetcode._2026.january;

import java.util.LinkedList;
import java.util.Queue;

public class January6th {

    public int maxLevelSum(TreeNode root) {
        int answer = 0;

        if (root == null) {
            return answer;
        }

        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int currTotal = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currTotal += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (max < currTotal) {
                max = currTotal;
                answer = depth;
            }

            depth++;
        }

        return answer;
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
