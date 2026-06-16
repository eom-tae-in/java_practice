package category.leetcode._2026.june;

public class June16th {

    public String processStr(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.setLength(stringBuilder.length() - 1);
                }
            } else if (ch == '#') {
                stringBuilder.append(stringBuilder);
            } else if (ch == '%') {
                stringBuilder.reverse();
            } else {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }
}
