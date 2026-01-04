package category.leetcode._2026.january;

public class January4th {

    public int sumFourDivisors(int[] nums) {
        int answer = 0;

        for (int num : nums) {
            int divisor = 0;

            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    if (divisor == 0) {
                        divisor = j;
                    } else {
                        divisor = 0;
                        break;
                    }
                }
            }

            if (divisor != 0 && divisor * divisor != num) {
                answer += 1;
                answer += num;
                answer += divisor;
                answer += num / divisor;
            }
        }

        return answer;
    }
}
