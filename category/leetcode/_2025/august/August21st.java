package category.leetcode._2025.august;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class August21st {

    public int numSubmat(int[][] mat) {
        int answer = 0;
        int columnLength = mat[0].length;
        int[] history = new int[columnLength];

        for (int[] row : mat) {
            for (int i = 0; i < columnLength; i++) {
                history[i] = row[i] == 0 ? 0 : history[i] + 1;
            }

            answer += getCount(history);
        }

        return answer;
    }

    private int getCount(int[] history) {
        int n = history.length;
        int[] count = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && history[stack.peek()] >= history[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int prevIndex = stack.peek();
                count[i] = count[prevIndex] + history[i] * (i - prevIndex);
            } else {
                count[i] = history[i] * (i + 1);
            }

            stack.push(i);
        }

        return Arrays.stream(count)
                .sum();
    }
}
