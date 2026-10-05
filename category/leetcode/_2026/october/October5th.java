package category.leetcode._2026.october;

public class October5th {

    public int scoreOfParentheses(String s) {
        int answer = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;

                if (s.charAt(i - 1) == '(') {
                    answer += 1 << depth;
                }
            }
        }

        return answer;
    }
}
