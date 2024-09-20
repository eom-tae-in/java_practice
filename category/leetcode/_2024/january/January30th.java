package category.leetcode._2024.january;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.function.BinaryOperator;

public class January30th {

    public int evalRPN(String[] tokens) {
        final Map<String, BinaryOperator<Long>> op = Map.of(
                "+", Long::sum, "-", (a, b) -> a - b, "*", (a, b) -> a * b, "/", (a, b) -> a / b);
        Deque<Long> stack = new ArrayDeque<>();

        for (final String token : tokens) {
            if (op.containsKey(token)) {
                final long a = stack.pop();
                final long b = stack.pop();
                stack.push(op.get(token).apply(b, a));
            } else {
                stack.push(Long.parseLong(token));
            }
        }

        return stack.pop().intValue();
    }
}
