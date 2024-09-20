package category.leetcode._2024.july;

import java.util.ArrayList;
import java.util.List;

public class July5th {

    public int[] nodesBetweenCriticalPoints(final ListNode head) {
        List<Integer> points = new ArrayList<>();
        ListNode current = head.next.next;
        ListNode prev = head.next;
        int prevStatus = 0;
        if (head.next.val > head.val) {
            prevStatus = 1;
        } else if (head.next.val < head.val) {
            prevStatus = -1;
        }
        int index = 2;
        while (current != null) {
            int currentStatus = 0;
            if (current.val > prev.val) {
                currentStatus = 1;
            } else if (current.val < prev.val) {
                currentStatus = -1;
            }
            if ((prevStatus == 1 && currentStatus == -1) || (prevStatus == -1 && currentStatus == 1)) {
                points.add(index - 1);
            }
            prevStatus = currentStatus;
            prev = current;
            current = current.next;
            index++;
        }
        int size = points.size();
        if (size < 2) {
            return new int[]{-1, -1};
        }
        int min = Integer.MAX_VALUE;
        int max = points.get(size - 1) - points.get(0);
        for (int i = 1; i < size; i++) {
            min = Math.min(min, points.get(i) - points.get(i - 1));
        }

        return new int[]{min, max};
    }
}
