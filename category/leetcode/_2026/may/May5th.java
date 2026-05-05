package category.leetcode._2026.may;

public class May5th {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int length = 1;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        tail.next = head;
        k = length - k % length;

        for (int i = 0; i < k - 1; i++) {
            head = head.next;
        }

        ListNode newHead = head.next;
        head.next = null;

        return newHead;
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
