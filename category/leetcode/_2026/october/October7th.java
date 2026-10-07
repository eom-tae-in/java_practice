package category.leetcode._2026.october;

import java.util.ArrayList;
import java.util.List;

public class October7th {

    public List<String> removeInvalidParentheses(String s) {
        List<String> answer = new ArrayList<>();
        dfs(s, 0, 0, '(', ')', answer);

        return answer;
    }

    private void dfs(
            String s,
            int scanStart,
            int removeStart,
            char open,
            char close,
            List<String> answer
    ) {
        int balance = 0;

        for (int i = scanStart; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == open) {
                balance++;
            } else if (ch == close) {
                balance--;
            }

            if (balance >= 0) {
                continue;
            }

            for (int j = removeStart; j <= i; j++) {
                if (s.charAt(j) != close) {
                    continue;
                }

                if (j > removeStart && s.charAt(j - 1) == close) {
                    continue;
                }

                String next = s.substring(0, j) + s.substring(j + 1);
                dfs(next, i, j, open, close, answer);
            }

            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();

        if (open == '(') {
            dfs(reversed, 0, 0, ')', '(', answer);
        } else {
            answer.add(reversed);
        }
    }
}
