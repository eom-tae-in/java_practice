package category.leetcode._2023.december;

public class December22nd {

    public int maxScore(final String s) {
        int answer = 0;
        int zeros = 0;
        int ones = (int) s.chars()
                .filter(ch -> ch == '1')
                .count();

        for (int i = 0; i < s.length() - 1; i++) {
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
