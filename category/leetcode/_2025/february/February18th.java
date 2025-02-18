package category.leetcode._2025.february;

import java.util.ArrayDeque;
import java.util.Deque;

public class February18th {

    public String smallestNumber(final String pattern) {
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        int length = pattern.length();

        for (int i = 0; i <= length; i++) {
            deque.offerFirst(i + 1);

            if (i == length || pattern.charAt(i) == 'I') {
                while (!deque.isEmpty()) {
                    stringBuilder.append(deque.pollFirst());
                }
            }
        }

        return stringBuilder.toString();
    }
}
