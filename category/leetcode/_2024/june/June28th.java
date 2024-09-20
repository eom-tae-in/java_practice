package category.leetcode._2024.june;

import java.util.Arrays;

public class June28th {

    public long maximumImportance(final int n, final int[][] roads) {
        int[] count = new int[n];
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
        }
        Arrays.sort(count);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += (long) count[i] * (i + 1);
        }

        return answer;
    }
}

