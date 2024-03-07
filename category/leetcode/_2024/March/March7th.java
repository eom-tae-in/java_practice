package category.leetcode._2024.March;

import java.util.ArrayList;
import java.util.List;

public class March7th {

    public ListNode middleNode(ListNode head) {
        int count = -1;
        List<ListNode> listNodes = new ArrayList<>();
        ListNode currentListNode = head;

        while (currentListNode != null) {
            listNodes.add(currentListNode);
            currentListNode = currentListNode.next;
            count++;
        }

        int index = count % 2 == 0 ? count / 2 : count / 2 + 1;
        return listNodes.get(index);
    }
}
