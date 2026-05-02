package category.leetcode._2026.may;

public class May2nd {

    public int rotatedDigits(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (isGoodNumber(i)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isGoodNumber(int num) {
        boolean result = false;

        while (num > 0) {
            int rest = num % 10;

            if (rest == 3 || rest == 4 || rest == 7) {
                return false;
            }

            if (rest == 2 || rest == 5 || rest == 6 || rest == 9) {
                result = true;
            }

            num /= 10;
        }

        return result;
    }
}
