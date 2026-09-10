package category.leetcode._2026.september;

public class September10th {

    private int answer = 0;

    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);

        return answer;
    }

    private SubTree dfs(TreeNode node) {
        if (node == null) {
            return new SubTree(0, 0);
        }

        SubTree left = dfs(node.left);
        SubTree right = dfs(node.right);
        int total = node.val + left.total + right.total;
        int count = 1 + left.count + right.count;
        int avg = total / count;

        if (avg == node.val) {
            answer++;
        }

        return new SubTree(total, count);
    }

    private static class SubTree {

        private final int total;
        private final int count;

        private SubTree(int total, int count) {
            this.total = total;
            this.count = count;
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
