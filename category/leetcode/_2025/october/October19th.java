package category.leetcode._2025.october;

import java.util.HashSet;
import java.util.Set;

public class October19th {

    private String answer;

    public String findLexSmallestString(String s, int a, int b) {
        answer = s;
        dfs(s, a, b, new HashSet<>());

        return answer;
    }

    private void dfs(String s, int a, int b, Set<String> seen) {
        if (seen.contains(s)) {
            return;
        }

        seen.add(s);

        if (answer.compareTo(s) > 0) {
            answer = s;
        }

        dfs(add(s, a), a, b, seen);
        dfs(rotate(s, b), a, b, seen);
    }

    private String add(String s, int a) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 1; i < sb.length(); i += 2) {
            sb.setCharAt(i, (char) ('0' + (s.charAt(i) - '0' + a) % 10));
        }

        return sb.toString();
    }

    private String rotate(String s, int b) {
        int n = s.length();

        return s.substring(n - b, n) + s.substring(0, n - b);
    }
}
