package category.leetcode._2025.february;

public class February22nd {

    private int i = 0;

    public TreeNode recoverFromPreorder(final String traversal) {
        return recoverFromPreorder(traversal, 0);
    }

    private TreeNode recoverFromPreorder(final String traversal, final int depth) {
        int nDashes = 0;

        while (i + nDashes < traversal.length() && traversal.charAt(i + nDashes) == '-') {
            ++nDashes;
        }

        if (nDashes != depth) {
            return null;
        }

        i += depth;
        int start = i;

        while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
            i++;
        }

        return new TreeNode(Integer.parseInt(traversal.substring(start, i)),
                recoverFromPreorder(traversal, depth + 1),
                recoverFromPreorder(traversal, depth + 1));
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
