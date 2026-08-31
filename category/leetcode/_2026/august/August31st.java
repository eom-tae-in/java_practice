package category.leetcode._2026.august;

public class August31st {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int left = -1;
        int right = -1;

        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{left, right};
        }

        int prev = head.val;
        head = head.next;
        int idx = 1;
        int prevCPIdx = -1;
        int minDistance = Integer.MAX_VALUE;

        while (head.next != null) {
            int curr = head.val;
            int next = head.next.val;

            if (isCriticalPoint(prev, curr, next)) {
                if (left == -1) {
                    left = idx;
                } else {
                    right = idx;

                    if (prevCPIdx != -1) {
                        minDistance = Math.min(minDistance, idx - prevCPIdx);
                    }
                }

                prevCPIdx = idx;
            }

            prev = head.val;
            head = head.next;
            idx++;
        }

        if (left == -1 || right == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, right - left};
    }

    private boolean isCriticalPoint(int prev, int curr, int next) {
        return (curr < prev && curr < next) || (curr > prev && curr > next);
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
