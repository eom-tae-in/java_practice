package category.leetcode._2024.August;

import java.util.PriorityQueue;
import java.util.Queue;

public class August12th {

    class KthLargest {

        private final int k;
        private final Queue<Integer> minHeap;

        public KthLargest(final int k, final int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>();
            for (final int num : nums) {
                heapify(num);
            }
        }

        public int add(final int val) {
            heapify(val);
            return minHeap.peek();
        }

        private void heapify(final int val) {
            minHeap.offer(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
}
