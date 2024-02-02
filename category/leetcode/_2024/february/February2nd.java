package category.leetcode._2024.february;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class February2nd {

    public List<Integer> sequentialDigits(final int low, final int high) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        while (!deque.isEmpty()) {
            final int num = deque.poll();
            if (num > high) {
                return answer;
            }
            if (low <= num && num <= high) {
                answer.add(num);
            }
            final int lastDigit = num % 10;
            if (lastDigit < 9) {
                deque.offer(num * 10 + lastDigit + 1);
            }
        }

        return answer;
    }
}
