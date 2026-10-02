package category.leetcode._2026.october;

import java.util.ArrayList;
import java.util.List;

public class October2nd {

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), answer);

        return answer;
    }

    private void dfs(
            int n,
            int open,
            int close,
            StringBuilder stringBuilder,
            List<String> answer
    ) {
        if (open == n && close == n) {
            answer.add(stringBuilder.toString());

            return;
        }

        if (open < n) {
            stringBuilder.append('(');
            dfs(n, open + 1, close, stringBuilder, answer);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        if (close < open) {
            stringBuilder.append(')');
            dfs(n, open, close + 1, stringBuilder, answer);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
