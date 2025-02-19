package category.leetcode._2025.february;

import java.util.ArrayList;
import java.util.List;

public class February19th {

    public String getHappyString(final int n, final int k) {
        List<String> happyStrings = new ArrayList<>();
        char[] chars = {'a', 'b', 'c'};
        dfs(0, n, new StringBuilder(), chars, happyStrings);

        return happyStrings.size() < k ? "" : happyStrings.get(k - 1);
    }

    private void dfs(
            final int i,
            final int n,
            final StringBuilder stringBuilder,
            final char[] chars,
            final List<String> happyStrings
    ) {
        if (i == n) {
            happyStrings.add(stringBuilder.toString());
            return;
        }

        for (char ch : chars) {
            if (stringBuilder.isEmpty()) {
                stringBuilder.append(ch);
                dfs(i + 1, n, stringBuilder, chars, happyStrings);
                stringBuilder.setLength(stringBuilder.length() - 1);
            } else {
                char lastChar = stringBuilder.charAt(stringBuilder.length() - 1);

                if (lastChar != ch) {
                    stringBuilder.append(ch);
                    dfs(i + 1, n, stringBuilder, chars, happyStrings);
                    stringBuilder.setLength(stringBuilder.length() - 1);
                }
            }
        }
    }
}
