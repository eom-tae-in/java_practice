package category.leetcode._2026.august;

public class August6th {

    public int smallestNumber(int n, int t) {
        int answer = n;

        while (true) {
            int result = getDigitProduct(answer);

            if (result % t == 0) {
                break;
            }

            answer++;
        }

        return answer;
    }

    private int getDigitProduct(int n) {
        int result = 1;

        while (n > 0) {
            result *= n % 10;
            n /= 10;
        }

        return result;
    }
}
