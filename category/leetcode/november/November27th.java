package category.leetcode.november;

import java.util.Arrays;

public class November27th {

    public int largestSubMatrix(final int[][] matrix) {
        int columnLength = matrix[0].length;
        int answer = 0;
        int[] cumulativeSum = new int[columnLength];

        for (int[] row : matrix) {
            for (int i = 0; i < columnLength; i++) {
                cumulativeSum[i] = row[i] == 0 ? 0 : cumulativeSum[i] + 1;
            }

            int[] sortedCumulativeSum = cumulativeSum.clone();
            Arrays.sort(sortedCumulativeSum);

            for (int i = 0; i < columnLength; i++) {
                answer = Math.max(answer, sortedCumulativeSum[i] * (columnLength - i));
            }
        }

        return answer;
    }
}
