package category.leetcode._2026.february;

public class February26th {

    public int numSteps(String s) {
        int step = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) - '0' + carry == 1) {
                step += 2;
                carry = 1;
            } else {
                step += 1;
            }
        }

        return step + carry;
    }
}
