package category.leetcode._2026.november;

public class November24th {

    public int maxLength(int[] nums) {
        int answer = 0;
        int maxProduct = 2520 * 10;

        for (int left = 0; left < nums.length; left++) {
            int product = 1;
            int currentGcd = 0;
            int currentLcm = 1;

            for (int right = left; right < nums.length; right++) {
                int value = nums[right];
                product *= value;

                if (product > maxProduct) {
                    break;
                }

                currentGcd = gcd(currentGcd, value);
                currentLcm = currentLcm / gcd(currentLcm, value) * value;

                if (product == currentGcd * currentLcm) {
                    answer = Math.max(answer, right - left + 1);
                }
            }
        }

        return answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }
}

