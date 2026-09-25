package category.leetcode._2026.september;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class September25th {

    private String expression;
    private int index;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.index = 0;
        Set<String> result = parseUnion();
        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }

    private Set<String> parseUnion() {
        Set<String> result = new HashSet<>(parseConcat());

        while (index < expression.length() && expression.charAt(index) == ',') {
            index++;
            result.addAll(parseConcat());
        }

        return result;
    }

    private Set<String> parseConcat() {
        Set<String> result = new HashSet<>();
        result.add("");

        while (index < expression.length()) {
            char ch = expression.charAt(index);

            if (ch == ',' || ch == '}') {
                break;
            }

            Set<String> next;

            if (ch == '{') {
                index++;
                next = parseUnion();
            } else {
                next = new HashSet<>();
                next.add(String.valueOf(ch));
            }

            index++;
            Set<String> combined = new HashSet<>();

            for (String a : result) {
                for (String b : next) {
                    combined.add(a + b);
                }
            }

            result = combined;
        }

        return result;
    }
}
