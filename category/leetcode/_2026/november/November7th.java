package category.leetcode._2026.november;

import java.util.Comparator;
import java.util.PriorityQueue;

public class November7th {

    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<long[]> busy = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        PriorityQueue<Integer> available = new PriorityQueue<>(Comparator.comparingInt((Integer a) -> servers[a])
                .thenComparingInt(a -> a));

        for (int i = 0; i < servers.length; i++) {
            available.offer(i);
        }

        int[] answer = new int[tasks.length];
        long time = 0;

        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                available.offer((int) busy.poll()[1]);
            }

            if (available.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    available.offer((int) busy.poll()[1]);
                }
            }

            int server = available.poll();
            answer[i] = server;

            busy.offer(new long[]{time + tasks[i], server});
        }

        return answer;
    }
}
