package category.leetcode._2024.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class May25th {

    public List<String> wordBreak(final String s, final List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }

    private List<String> dfs(final String s, final List<String> wordDict, final Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> subsets = new ArrayList<>();

        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (wordDict.contains(prefix)) {
                for (String subset : dfs(suffix, wordDict, map)) {
                    subsets.add(prefix + " " + subset);
                }
            }
        }

        if (wordDict.contains(s)) {
            subsets.add(s);
        }

        map.put(s, subsets);
        return subsets;
    }
}
