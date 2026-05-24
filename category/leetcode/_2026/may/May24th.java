package category.leetcode._2026.may;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class May24th {

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] < arr[i])) {
                List<Integer> indices = new ArrayList<>(List.of(stack.pop()));

                while (!stack.isEmpty() && arr[stack.peek()] == arr[indices.get(0)]) {
                    indices.add(stack.pop());
                }

                for (int j : indices) {
                    if (i < n && i - j <= d) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }

                    if (!stack.isEmpty() && j - stack.peek() <= d) {
                        dp[stack.peek()] = Math.max(dp[stack.peek()], dp[j] + 1);
                    }
                }
            }

            stack.push(i);
        }

        return Arrays.stream(dp)
                .max()
                .getAsInt() + 1;
    }
}
