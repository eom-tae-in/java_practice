package category.leetcode._2024.october;

import java.util.ArrayDeque;
import java.util.Deque;

public class October10th {

    public int maxWidthRamp(final int[] nums) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (deque.isEmpty() || nums[i] < nums[deque.peek()]) {
                deque.push(i);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peek()]) {
                answer = Math.max(answer, i - deque.poll());
            }
        }

        return answer;
    }
}
