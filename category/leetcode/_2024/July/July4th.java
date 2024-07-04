package category.leetcode._2024.July;

public class July4th {

    public ListNode mergeNodes(final ListNode head) {
        ListNode node = head.next;
        while (node != null) {
            int sum = 0;
            ListNode current = node;
            while (current.val > 0) {
                sum += current.val;
                current = current.next;
            }
            node.val = sum;
            node.next = current.next;
            node = current.next;
        }

        return head.next;
    }
}


class ListNode {

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
