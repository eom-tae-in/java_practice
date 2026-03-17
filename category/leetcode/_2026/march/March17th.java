package category.leetcode._2026.march;

import java.util.Arrays;

public class March17th {

    public int largestSubmatrix(int[][] matrix) {
        int colLen = matrix[0].length;
        int[] hist = new int[colLen];
        int answer = 0;

        for (int[] row : matrix) {
            for (int i = 0; i < colLen; i++) {
                hist[i] = row[i] == 0 ? 0 : hist[i] + 1;
            }

            int[] sortedHist = hist.clone();
            Arrays.sort(sortedHist);

            for (int j = 0; j < colLen; j++) {
                answer = Math.max(answer, sortedHist[j] * (colLen - j));
            }
        }

        return answer;
    }
}
