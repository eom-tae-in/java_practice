package category.leetcode._2026.may;

public class May29th {

    public int minElement(int[] nums) {
        int answer = Integer.MAX_VALUE;

        for (int num : nums) {
            answer = Math.min(answer, getDigitSum(num));
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
