package category.leetcode._2026.june;

public class June15th {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }

        slowPrev.next = slow.next;

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
