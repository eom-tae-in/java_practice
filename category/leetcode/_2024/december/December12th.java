package category.leetcode._2024.december;

import java.util.PriorityQueue;
import java.util.Queue;

public class December12th {

    public long pickGifts(final int[] gifts, final int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        long remainingGifts = 0;

        for (int gift : gifts) {
            queue.offer(gift);
        }

        for (int i = 0; i < k; i++) {
            queue.offer((int) Math.sqrt(queue.poll()));
        }

        while (!queue.isEmpty()) {
            remainingGifts += queue.poll();
        }

        return remainingGifts;
    }
}
