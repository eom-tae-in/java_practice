package category.leetcode._2026.june;

public class June14th {

    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode primary = head;
        ListNode secondary = reverse(slow);
        int answer = 0;

        while (secondary != null) {
            answer = Math.max(answer, primary.val + secondary.val);
            primary = primary.next;
            secondary = secondary.next;
        }

        return answer;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
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
