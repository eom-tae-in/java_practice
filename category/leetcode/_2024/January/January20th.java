package category.leetcode._2024.January;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class January20th {

    public static int sumSubarrayMins(int[] arr) {
        final int n = arr.length;
        final int mod = 1_000_000_007;
        long answer = 0;
        int[] preMinIndex = new int[n];
        int[] nextMinIndex = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();

        Arrays.fill(preMinIndex, -1);
        Arrays.fill(nextMinIndex, n);

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[deque.peek()] > arr[i]) {
                nextMinIndex[deque.poll()] = i;
            }
            if (!deque.isEmpty()) {
                preMinIndex[i] = deque.peek();
            }
            deque.push(i);
        }

        for (int i = 0; i < n; i++) {
            answer += (long) arr[i] * (i - preMinIndex[i]) * (nextMinIndex[i] - i);
            answer %= mod;
        }

        return (int) answer;
    }
}
