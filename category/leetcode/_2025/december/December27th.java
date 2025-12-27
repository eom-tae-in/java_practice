package category.leetcode._2025.december;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class December27th {

    public int mostBooked(int n, int[][] meetings) {
        int[] roomCount = new int[n];
        Queue<Integer> usableRoom = new PriorityQueue<>();
        Arrays.sort(meetings, Comparator.comparingInt((int[] row) -> row[0])
                .thenComparingInt(row -> row[1]));

        for (int i = 0; i < n; i++) {
            usableRoom.offer(i);
        }

        Queue<Meeting> queue = new PriorityQueue<>(
                Comparator.comparingLong((Meeting m) -> m.endTime)
                        .thenComparingInt(m -> m.roomIndex)
        );

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!queue.isEmpty() && queue.peek().endTime <= start) {
                usableRoom.offer(queue.poll().roomIndex);
            }

            if (usableRoom.isEmpty()) {
                Meeting poll = queue.poll();
                roomCount[poll.roomIndex]++;
                queue.offer(new Meeting(poll.roomIndex, poll.endTime + (end - start)));
            } else {
                int index = usableRoom.poll();
                roomCount[index]++;
                queue.offer(new Meeting(index, end));
            }
        }

        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (roomCount[i] > roomCount[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private record Meeting(int roomIndex, long endTime) {
    }
}
