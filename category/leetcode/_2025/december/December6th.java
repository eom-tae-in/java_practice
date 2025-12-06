package category.leetcode._2025.december;

import java.util.ArrayDeque;
import java.util.Deque;

public class December6th {

    private static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];
        dp[0] = 1;
        pref[0] = 1;
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            updateMinQueue(minQ, nums, right);
            updateMaxQueue(maxQ, nums, right);

            while (!isValidWindow(minQ, maxQ, nums, k)) {
                if (minQ.peekFirst() == left) {
                    minQ.pollFirst();
                }

                if (maxQ.peekFirst() == left) {
                    maxQ.pollFirst();
                }

                left++;
            }

            long sum = pref[right];

            if (left > 0) {
                sum = (sum - pref[left - 1] + MOD) % MOD;
            }

            dp[right + 1] = sum;
            pref[right + 1] = (pref[right] + dp[right + 1]) % MOD;
        }

        return (int) dp[n];
    }

    private void updateMinQueue(Deque<Integer> minQ, int[] nums, int idx) {
        while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[idx]) {
            minQ.pollLast();
        }

        minQ.addLast(idx);
    }

    private void updateMaxQueue(Deque<Integer> maxQ, int[] nums, int idx) {
        while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[idx]) {
            maxQ.pollLast();
        }

        maxQ.addLast(idx);
    }

    private boolean isValidWindow(Deque<Integer> minQ, Deque<Integer> maxQ, int[] nums, int k) {
        return nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] <= k;
    }
}

