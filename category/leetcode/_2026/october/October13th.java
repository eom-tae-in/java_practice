package category.leetcode._2026.october;

import java.util.Arrays;

public class October13th {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int[] squares = new int[n];

        for (int i = 0; i < n; i++) {
            squares[i] = nums[i] * nums[i];
        }

        Arrays.sort(squares);
        long answer = 0;
        int half = n / 2;

        for (int i = 0; i < n; i++) {
            int curr = squares[i];

            if (i < half) {
                curr = -curr;
            }

            answer += curr;
        }

        return answer;
    }
}
