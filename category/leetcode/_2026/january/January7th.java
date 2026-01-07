package category.leetcode._2026.january;

public class January7th {

    private static final int MOD = 1_000_000_007;
    private long max = 0;

    public int maxProduct(TreeNode root) {
        int totalSum = getSum(root);
        postOrder(root, totalSum);

        return (int) (max % MOD);
    }

    private int postOrder(TreeNode node, int totalSum) {
        if (node == null) {
            return 0;
        }

        int left = postOrder(node.left, totalSum);
        int right = postOrder(node.right, totalSum);
        int subSum = left + right + node.val;
        long currValue = (long) subSum * (totalSum - subSum);

        if (max < currValue) {
            max = currValue;
        }

        return subSum;
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return node.val + getSum(node.left) + getSum(node.right);
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
