package category.leetcode._2026.october;

public class October3rd {

    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                answer = Math.max(answer, left + right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                answer = Math.max(answer, left + right);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return answer;
    }
}
