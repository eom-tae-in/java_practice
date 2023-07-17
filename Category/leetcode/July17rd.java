package Category.leetcode;

import java.util.Stack;

public class July17rd {

    class ListNode {

        private int val;
        private ListNode next;

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

    class solution {
        public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
            Stack<Integer> list1 = addListValueToStack(l1);
            Stack<Integer> list2 = addListValueToStack(l2);

            ListNode listNode = null;
            int carry = 0;

            while (list1.size() > 0 || list2.size() > 0 || carry != 0) {
                int sum = 0;
                if (!list1.isEmpty()) {
                    sum += list1.pop();
                }
                if (!list2.isEmpty()) {
                    sum += list2.pop();
                }
                sum += carry;

                listNode = new ListNode(sum % 10, listNode);
                carry = sum / 10;
            }
            return listNode;
        }
    }

    private Stack<Integer> addListValueToStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();

        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        return stack;
    }
}
