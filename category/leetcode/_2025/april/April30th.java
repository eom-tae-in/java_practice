package category.leetcode._2025.april;

public class April30th {

    public int findNumbers(final int[] nums) {
        int answer = 0;

        for (int num : nums) {
            if (isEvenDigit(num)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isEvenDigit(final int num) {
        return 9 < num && num < 100 ||
                999 < num && num < 10000 ||
                num == 100000;
    }
}
