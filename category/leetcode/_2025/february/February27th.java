package category.leetcode._2025.february;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class February27th {

    public int lenLongestFibSubseq(final int[] arr) {
        int n = arr.length;
        int answer = 0;
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(A -> Arrays.fill(A, 2));
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            numToIndex.put(arr[i], i);
        }

        for (int j = 0; j < n; ++j) {
            for (int k = j + 1; k < n; ++k) {
                int ai = arr[k] - arr[j];

                if (ai < arr[j] && numToIndex.containsKey(ai)) {
                    int i = numToIndex.get(ai);
                    dp[j][k] = dp[i][j] + 1;
                    answer = Math.max(answer, dp[j][k]);
                }
            }
        }

        return answer;
    }
}
