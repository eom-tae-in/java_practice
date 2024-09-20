package category.leetcode._2024.may;

import java.util.Arrays;

public class May9th {

    public long maximumHappinessSum(final int[] happiness, final int k) {
        long answer = 0;
        int length = happiness.length;
        int decrease = 0;
        Arrays.sort(happiness);

        for (int i = length - 1; i >= length - k; i--) {
            answer += Math.max(0, happiness[i] - decrease++);
        }

        return answer;
    }
}
