package category.leetcode._2024.september;

public class September7th {

    public boolean isSubPath(final ListNode head, final TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSub(head, root) ||
                isSubPath(head, root.left) ||
                isSubPath(head, root.right);
    }

    private boolean isSub(final ListNode head, final TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return head.val == root.val &&
                (isSub(head.next, root.left) || isSub(head.next, root.right));
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(final int val) {
            this.val = val;
        }

        ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
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
