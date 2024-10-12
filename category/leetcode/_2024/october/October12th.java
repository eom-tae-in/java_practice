package category.leetcode._2024.october;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class October12th {

    public int minGroups(final int[][] intervals) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && interval[0] > minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(interval[1]);
        }

        return minHeap.size();
    }
}
