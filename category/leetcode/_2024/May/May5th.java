package category.leetcode._2024.May;

public class May5th {

    public void deleteNode(final ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
