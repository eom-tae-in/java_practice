package category.leetcode._2025.february;

public class February12th {

    public int maximumSum(final int[] nums) {
        int[] digits = new int[82];
        int answer = -1;

        for (int num : nums) {
            int digit = getDigitSum(num);
            int prev = digits[digit];

            if (prev != 0) {
                answer = Math.max(answer, prev + num);
            }

            digits[digit] = Math.max(prev, num);
        }

        return answer;
    }

    private int getDigitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
