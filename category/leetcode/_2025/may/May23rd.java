package category.leetcode._2025.may;

public class May23rd {

    public long maximumValueSum(
            final int[] nums,
            final int k,
            final int[][] edges
    ) {
        int minDiff = Integer.MAX_VALUE;
        int xorLargeCase = 0;
        long answer = 0;

        for (int num : nums) {
            int xor = num ^ k;

            if (xor > num) {
                xorLargeCase++;
                answer += xor;
            } else {
                answer += num;
            }

            minDiff = Math.min(minDiff, Math.abs(num - xor));
        }

        if (xorLargeCase % 2 == 1) {
            answer -= minDiff;
        }

        return answer;
    }
}
