package category.leetcode._2026.august;

public class August23rd {

    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;
        int questionDiff = 0;
        int sumDiff = 0;

        for (int i = 0; i < n; i++) {
            int flag = i < half ? 1 : -1;
            char curr = num.charAt(i);

            if (curr == '?') {
                questionDiff += flag;
            } else {
                sumDiff += flag * (curr - '0');
            }
        }

        if (questionDiff % 2 == 1) {
            return true;
        }

        return 2 * sumDiff != -9 * questionDiff;
    }
}
