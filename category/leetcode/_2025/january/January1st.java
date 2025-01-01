package category.leetcode._2025.january;

public class January1st {

    public int maxScore(final String s) {
        int answer = 0;
        int zeros = 0;
        int ones = (int) s.chars()
                .filter(c -> c == '1')
                .count();

        for (int i = 0; i + 1 < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }
            answer = Math.max(answer, zeros + ones);
        }

        return answer;
    }
}
