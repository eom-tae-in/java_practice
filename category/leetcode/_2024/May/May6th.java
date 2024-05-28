package category.leetcode._2024.May;

public class May6th {

    public ListNode removeNodes(final ListNode head) {
        if (head.next == null) {
            return head;
        }

        head.next = removeNodes(head.next);
        return head.val < head.next.val ? head.next : head;
    }
}
