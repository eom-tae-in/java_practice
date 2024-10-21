package category.leetcode._2024.october;

import java.util.HashSet;
import java.util.Set;

public class October21st {

    private int answer = 0;

    public int maxUniqueSplit(final String s) {
        dfs(s, 0, new HashSet<>());
        return answer;
    }


    private void dfs(final String s, final int start, final Set<String> seen) {
        if (start == s.length()) {
            answer = Math.max(answer, seen.size());
            return;
        }

        for (int i = start + 1; i <= s.length(); ++i) {
            final String current = s.substring(start, i);
            if (seen.contains(current)) {
                continue;
            }
            seen.add(current);
            dfs(s, i, seen);
            seen.remove(current);
        }
    }
}
