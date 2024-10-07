package category.leetcode._2024.october;

import java.util.ArrayDeque;
import java.util.Deque;

public class October7th {

    public int minLength(final String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (final char c : s.toCharArray()) {
            if (c == 'B' && match(stack, 'A')) {
                stack.pop();
            } else if (c == 'D' && match(stack, 'C')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size();
    }

    private boolean match(final Deque<Character> stack, final char c) {
        return !stack.isEmpty() && stack.peek() == c;
    }
}
