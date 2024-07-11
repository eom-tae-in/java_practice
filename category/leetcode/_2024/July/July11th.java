package category.leetcode._2024.July;

public class July11th {

    private int index = 0;

    public String reverseParentheses(final String s) {
        int n = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (index < n && s.charAt(index) != ')') {
            if (s.charAt(index) == '(') {
                index++;
                String current = reverseParentheses(s);
                index++;
                StringBuilder sb = new StringBuilder();
                sb.append(current).reverse();
                stringBuilder.append(sb);
            } else {
                stringBuilder.append(s.charAt(index++));
            }
        }

        return stringBuilder.toString();
    }
}
