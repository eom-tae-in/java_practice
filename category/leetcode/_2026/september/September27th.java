package category.leetcode._2026.september;

public class September27th {

    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        int[] stack = new int[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack[top++] = i;
            } else if (s.charAt(i) == ')') {
                int j = stack[--top];
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder answer = new StringBuilder();
        int direction = 1;

        for (int i = 0; i < n; i += direction) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == ')') {
                i = pair[i];
                direction *= -1;
            } else {
                answer.append(ch);
            }
        }

        return answer.toString();
    }
}
