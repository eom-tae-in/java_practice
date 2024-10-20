package category.leetcode._2024.october;

import java.util.ArrayList;
import java.util.List;

public class October20th {

    public boolean parseBoolExpr(final String expression) {
        return dfs(expression, 0, expression.length() - 1);
    }

    private boolean dfs(final String expression, final int s, final int e) {
        if (s == e) {
            return expression.charAt(s) == 't';
        }

        List<Boolean> expressions = new ArrayList<>();
        int layer = 0;
        int left = 0;
        char operator = ' ';

        for (int i = s; i <= e; ++i) {
            char c = expression.charAt(i);
            if (layer == 0 && (c == '!' || c == '&' || c == '|')) {
                operator = c;
            } else if (c == '(' && ++layer == 1) {
                left = i + 1;
            } else if (c == ')' && --layer == 0) {
                expressions.add(dfs(expression, left, i - 1));
            } else if (c == ',' && layer == 1) {
                expressions.add(dfs(expression, left, i - 1));
                left = i + 1;
            }
        }

        if (operator == '&') {
            boolean ans = true;
            for (boolean exp : expressions) {
                ans &= exp;
            }

            return ans;
        }

        if (operator == '|') {
            boolean ans = false;
            for (boolean exp : expressions) {
                ans |= exp;
            }

            return ans;
        }

        return !expressions.get(0);
    }
}
