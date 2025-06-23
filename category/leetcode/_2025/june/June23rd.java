package category.leetcode._2025.june;

public class June23rd {

    private final int[] digits = new int[100];

    public long kMirror(int k, int n) {
        long answer = 0;
        int left = 1;
        int count = 0;

        while (count < n) {
            int right = left * 10;

            for (int op = 0; op < 2; op++) {
                for (int i = left; i < right && count < n; i++) {
                    long num = i;
                    int post = op == 0 ? i / 10 : i;

                    while (post > 0) {
                        num = num * 10 + post % 10;
                        post /= 10;
                    }

                    if (isMirror(num, k)) {
                        count++;
                        answer += num;
                    }
                }
            }

            left = right;
        }

        return answer;
    }

    private boolean isMirror(long num, int k) {
        int index = -1;

        while (num > 0) {
            digits[++index] = (int) (num % k);
            num /= k;
        }

        for (int i = 0, j = index; i < j; i++, j--) {
            if (digits[j] != digits[i]) {
                return false;
            }
        }

        return true;
    }
}
