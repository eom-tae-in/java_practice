package category.leetcode._2024.december;

import java.util.ArrayDeque;
import java.util.Queue;

public class December31st {

    public int mincostTickets(final int[] days, final int[] costs) {
        int answer = 0;
        Queue<int[]> last7 = new ArrayDeque<>();
        Queue<int[]> last30 = new ArrayDeque<>();

        for (int day : days) {
            while (!last7.isEmpty() && last7.peek()[0] + 7 <= day) {
                last7.poll();
            }

            while (!last30.isEmpty() && last30.peek()[0] + 30 <= day) {
                last30.poll();
            }

            last7.offer(new int[]{day, answer + costs[1]});
            last30.offer(new int[]{day, answer + costs[2]});
            answer = Math.min(answer + costs[0], Math.min(last7.peek()[1], last30.peek()[1]));
        }

        return answer;
    }
}
