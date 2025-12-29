package category.leetcode._2025.december;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class December29th {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        Set<String> failed = new HashSet<>();

        for (String str : allowed) {
            String key = str.substring(0, 2);
            char value = str.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }

        return canBuild(bottom, failed, map);
    }

    private boolean canBuild(String curr, Set<String> failed, Map<String, List<Character>> map) {
        if (curr.length() == 1) {
            return true;
        }

        if (failed.contains(curr)) {
            return false;
        }

        List<String> next = new ArrayList<>();
        dfs(0, curr, new StringBuilder(), next, map);

        for (String n : next) {
            if (canBuild(n, failed, map)) {
                return true;
            }
        }

        failed.add(curr);

        return false;
    }

    private void dfs(
            int idx,
            String curr,
            StringBuilder stringBuilder,
            List<String> next,
            Map<String, List<Character>> map
    ) {
        if (idx == curr.length() - 1) {
            next.add(stringBuilder.toString());

            return;
        }

        String target = curr.substring(idx, idx + 2);

        if (!map.containsKey(target)) {
            return;
        }

        for (char ch : map.get(target)) {
            stringBuilder.append(ch);
            dfs(idx + 1, curr, stringBuilder, next, map);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
