package category.leetcode._2026.october;

import java.util.ArrayDeque;
import java.util.Deque;

public class October1st {

    private static final String FRONT = "({[";
    private static final String REAR = ")}]";


    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (FRONT.indexOf(ch) != -1) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char pop = stack.pop();

                if (FRONT.indexOf(pop) != REAR.indexOf(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
