package Category.leetcode.August;

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

public class August15rd {
    public ListNode partition(ListNode head, final int x) {
        ListNode smallValueHead = new ListNode(0);
        ListNode largeOrSameValueHead = new ListNode(0);
        ListNode smallValue = smallValueHead;
        ListNode largeOrSameValue = largeOrSameValueHead;
        while (head != null) {
            if (head.val < x) {
                smallValue.next = head;
                smallValue = head;
            } else {
                largeOrSameValue.next = head;
                largeOrSameValue = head;
            }
            head = head.next;
        }
        largeOrSameValue.next = null;
        smallValue.next = largeOrSameValueHead.next;

        return smallValueHead.next;
    }
}
