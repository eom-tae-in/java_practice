package category.leetcode._2025.november;

import java.util.HashSet;
import java.util.Set;

public class November1st {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (head != null) {
            if (!set.contains(head.val)) {
                tail.next = head;
                tail = tail.next;
            }

            head = head.next;
        }

        tail.next = null;

        return dummy.next;
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
