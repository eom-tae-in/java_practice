package category.leetcode._2025.july;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class July7th {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(row -> row[0]));
        Queue<Integer> queue = new PriorityQueue<>();
        int now = 1;
        int endDay = 0;
        int count = 0;
        int index = 0;
        int n = events.length;

        for (int[] event : events) {
            endDay = Math.max(endDay, event[1]);
        }

        while (now <= endDay) {
            while (index < n && now == events[index][0]) {
                queue.offer(events[index][1]);
                index++;
            }

            while (!queue.isEmpty() && queue.peek() < now) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                queue.poll();
                count++;
            }

            now++;
        }

        return count;
    }
}
