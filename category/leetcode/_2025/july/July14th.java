package category.leetcode._2025.july;

public class July14th {

    public int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();

        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(stringBuilder.toString(), 2);
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
