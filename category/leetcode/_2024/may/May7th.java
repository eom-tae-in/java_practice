package category.leetcode._2024.may;

public class May7th {

    public ListNode doubleIt(final ListNode head) {
        if (calculateCarry(head) == 1) {
            return new ListNode(1, head);
        }

        return head;
    }

    private int calculateCarry(final ListNode node) {
        int val = node.val * 2;
        if (node.next != null) {
            val += calculateCarry(node.next);
        }
        node.val = val % 10;

        return val / 10;
    }
}

