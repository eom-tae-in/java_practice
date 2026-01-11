package category.leetcode._2026.january;

import java.util.ArrayDeque;
import java.util.Deque;

public class January11th {

    public int maximalRectangle(char[][] matrix) {
        int[] memory = new int[matrix[0].length];
        int answer = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                memory[i] = row[i] == '0' ? 0 : memory[i] + 1;
            }

            answer = Math.max(answer, calculateMaxRectangle(memory));
        }

        return answer;
    }

    private int calculateMaxRectangle(int[] memory) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= memory.length; i++) {
            while (!deque.isEmpty() && (i == memory.length || memory[deque.peek()] > memory[i])) {
                int height = memory[deque.poll()];
                int width = deque.isEmpty() ? i : (i - 1) - deque.peek();
                answer = Math.max(answer, height * width);
            }
            deque.push(i);
        }

        return answer;
    }
}
