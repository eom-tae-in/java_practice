package category.leetcode._2026.october;

public class October8th {

    public String removeOuterParentheses(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (depth > 0) {
                    stringBuilder.append('(');
                }

                depth++;
            } else {
                depth--;

                if (depth > 0) {
                    stringBuilder.append(')');
                }
            }
        }

        return stringBuilder.toString();
    }
}
