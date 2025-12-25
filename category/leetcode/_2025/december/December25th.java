package category.leetcode._2025.december;

import java.util.Arrays;

public class December25th {

    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long answer = 0;
        int decremented = 0;
        Arrays.sort(happiness);

        for (int i = n - 1; i >= n - k; i--) {
            answer += Math.max(0, happiness[i] - decremented);
            decremented++;
        }

        return answer;
    }
}
