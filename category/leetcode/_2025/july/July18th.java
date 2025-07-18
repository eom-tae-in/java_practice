package category.leetcode._2025.july;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class July18th {

    public long minimumDifference(int[] nums) {
        long answer = Long.MAX_VALUE;
        int n = nums.length / 3;
        long[] minSum = new long[2 * n];
        Queue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> right = new PriorityQueue<>();
        long leftSum = 0;
        long rightSum = 0;

        for (int i = 0; i < 2 * n; i++) {
            int current = nums[i];
            left.offer(current);
            leftSum += current;

            if (left.size() > n) {
                leftSum -= left.poll();
            }

            if (left.size() == n) {
                minSum[i] = leftSum;
            }
        }

        for (int i = nums.length - 1; i >= n; i--) {
            int current = nums[i];
            right.offer(current);
            rightSum += current;

            if (right.size() > n) {
                rightSum -= right.poll();
            }

            if (right.size() == n) {
                answer = Math.min(answer, minSum[i - 1] - rightSum);
            }
        }

        return answer;
    }
}
