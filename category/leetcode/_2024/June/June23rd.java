package category.leetcode._2024.June;

import java.util.ArrayDeque;
import java.util.Deque;

public class June23rd {

    public int longestSubarray(final int[] nums, final int limit) {
        int answer = 1;
        Deque<Integer> minQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();

        for (int left = 0, right = 0; right < nums.length; ++right) {
            while (!minQueue.isEmpty() && minQueue.peekLast() > nums[right]) {
                minQueue.pollLast();
            }
            minQueue.addLast(nums[right]);
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(nums[right]);
            while (maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
                if (minQueue.peekFirst() == nums[left]) {
                    minQueue.pollFirst();
                }
                if (maxQueue.peekFirst() == nums[left]) {
                    maxQueue.pollFirst();
                }
                ++left;
            }
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
