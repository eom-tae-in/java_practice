package category.leetcode._2026.september;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class September26th {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> values = new HashMap<>();

        for (List<String> pair : knowledge) {
            values.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(') {
                result.append(s.charAt(i));
                continue;
            }

            int start = ++i;
            while (s.charAt(i) != ')') {
                i++;
            }

            String key = s.substring(start, i);
            result.append(values.getOrDefault(key, "?"));
        }

        return result.toString();
    }
}
