package category.leetcode._2024.september;

public class September8th {

    public ListNode[] splitListToParts(final ListNode root, final int k) {
        ListNode[] answer = new ListNode[k];
        final int length = getLength(root);
        final int subLength = length / k;
        int remainder = length % k;
        ListNode prev = null;
        ListNode head = root;
        for (int i = 0; i < k; i++, remainder--) {
            answer[i] = head;
            for (int j = 0; j < subLength + (remainder > 0 ? 1 : 0); j++) {
                prev = head;
                head = head.next;
            }
            if (prev != null) {
                prev.next = null;
            }
        }

        return answer;
    }

    private int getLength(final ListNode root) {
        int length = 0;
        for (ListNode curr = root; curr != null; curr = curr.next) {
            length++;
        }
        return length;
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
