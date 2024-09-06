package category.leetcode._2024.september;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class September6th {

    public ListNode modifiedList(final int[] nums, final ListNode head) {
        ListNode listNode = new ListNode(0, head);
        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        for (ListNode current = listNode; current.next != null; ) {
            if (set.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return listNode.next;
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
