package category.leetcode._2024.september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class September19th {

    public List<Integer> diffWaysToCompute(final String expression) {
        return ways(expression, new HashMap<>());
    }

    private List<Integer> ways(final String s, final Map<String, List<Integer>> mem) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i))) {
                for (final int a : ways(s.substring(0, i), mem)) {
                    for (final int b : ways(s.substring(i + 1), mem)) {
                        if (s.charAt(i) == '+') {
                            ans.add(a + b);
                        } else if (s.charAt(i) == '-') {
                            ans.add(a - b);
                        } else {
                            ans.add(a * b);
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            mem.put(s, List.of(Integer.parseInt(s)));
            return mem.get(s);
        }
        mem.put(s, ans);
        return ans;
    }
}
