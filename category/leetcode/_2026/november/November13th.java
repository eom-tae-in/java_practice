package category.leetcode._2026.november;

import java.util.ArrayDeque;
import java.util.Deque;

public class November13th {

    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        long answer = 0;
        long cost = 0;
        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[left]) {
                int index = deque.pollLast();
                int nextIndex = deque.isEmpty() ? right + 1 : deque.peekLast();
                long width = nextIndex - index;
                long height = (long) nums[left] - nums[index];
                cost += width * height;
            }

            deque.offerLast(left);

            while (cost > k) {
                int maxIndex = deque.peekFirst();
                cost -= (long) nums[maxIndex] - nums[right];

                if (maxIndex == right) {
                    deque.pollFirst();
                }

                right--;
            }

            answer += right - left + 1L;
        }

        return answer;
    }
}
