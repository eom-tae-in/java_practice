package category.leetcode.november;

import java.util.PriorityQueue;
import java.util.Queue;

public class November6th {

    private Queue<Integer> minHeap = new PriorityQueue<>();
    private int num = 0;

    public November6th(int n) {
    }

    public int reserve() {
        if (minHeap.isEmpty()) {
            return ++num;
        }
        return minHeap.poll();
    }

    public void unreserve(final int seatNumber) {
        minHeap.offer(seatNumber);
    }
}
