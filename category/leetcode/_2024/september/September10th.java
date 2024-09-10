package category.leetcode._2024.september;

public class September10th {

    public ListNode insertGreatestCommonDivisors(final ListNode head) {
        if (head == null) {
            return null;
        }
        for (ListNode current = head; current.next != null; ) {
            current.next = new ListNode(calculateGcd(current.val, current.next.val), current.next);
            current = current.next.next;
        }

        return head;
    }

    private int calculateGcd(final int a, final int b) {
        return b == 0 ? a : calculateGcd(b, a % b);
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
}
