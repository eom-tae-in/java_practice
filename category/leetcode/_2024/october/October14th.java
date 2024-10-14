package category.leetcode._2024.october;

import java.util.PriorityQueue;
import java.util.Queue;

public class October14th {

    public long maxKelements(final int[] nums, final int k) {
        long answer = 0;
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int count = 0;

        for (int num : nums) {
            queue.offer(num);
        }

        while (!queue.isEmpty() && ++count <= k) {
            int num = queue.poll();
            answer += num;
            num = (int) Math.ceil((double) num / 3);
            queue.offer(num);
        }

        return answer;
    }
}
