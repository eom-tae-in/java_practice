package category.leetcode._2025.december;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class December23rd {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt((int[] event) -> event[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] element) -> element[0]));
        int maxVal = 0;
        int answer = 0;

        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            int value = event[2];

            while (!pq.isEmpty() && pq.peek()[0] < start) {
                maxVal = Math.max(maxVal, pq.poll()[1]);
            }

            answer = Math.max(answer, maxVal + value);
            pq.add(new int[]{end, value});
        }

        return answer;
    }
}
