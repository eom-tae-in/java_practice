package category.leetcode._2025.may;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class May1st {

    public int maxTaskAssign(
            int[] tasks,
            int[] workers,
            int pills,
            int strength
    ) {
        int answer = 0;
        int left = 0;
        int right = Math.min(tasks.length, workers.length);
        Arrays.sort(tasks);
        Arrays.sort(workers);

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canComplete(mid, workers, tasks, pills, strength)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canComplete(
            int count,
            int[] workers,
            int[] tasks,
            int pills,
            int strength
    ) {
        Deque<Integer> deque = new ArrayDeque<>();
        int workerIndex = workers.length - 1;

        for (int i = count - 1; i >= 0; i--) {
            while (workerIndex >= workers.length - count && workers[workerIndex] + strength >= tasks[i]) {
                deque.offerFirst(workers[workerIndex]);
                workerIndex--;
            }

            if (deque.isEmpty()) {
                return false;
            } else if (deque.getLast() >= tasks[i]) {
                deque.pollLast();
            } else {
                if (pills <= 0) {
                    return false;
                }

                pills--;
                deque.pollFirst();
            }
        }

        return true;
    }
}
