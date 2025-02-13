package category.leetcode._2025.february;

import java.util.PriorityQueue;
import java.util.Queue;

public class February13th {

    public int minOperations(final int[] nums, final int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        int count = 0;

        for (int num : nums) {
            if (num < k) {
                queue.offer(num);
            }
        }

        while (!queue.isEmpty()) {
            if (queue.size() < 2) {
                if (queue.peek() < k) {
                    count++;
                }
                break;
            } else {
                int primary = queue.poll();
                int secondary = queue.poll();
                long num = (long) primary * 2 + secondary;

                if (num < k) {
                    queue.offer((int) num);
                }

                count++;
            }
        }

        return count;
    }
}
