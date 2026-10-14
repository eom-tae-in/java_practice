package category.leetcode._2026.october;

public class October14th {

    public String maxSumOfSquares(int num, int sum) {
        if (sum < 1 || sum > 9L * num) {
            return "";
        }

        StringBuilder answer = new StringBuilder(num);

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            answer.append(digit);
            sum -= digit;
        }

        return answer.toString();
    }
}
