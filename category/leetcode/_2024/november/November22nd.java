package category.leetcode._2024.november;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class November22nd {

    public int maxEqualRowsAfterFlips(final int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int[] flip = new int[columnLength];
        int answer = 0;
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < rowLength; i++) {
            if (seen.contains(i)) {
                continue;
            }
            int currentCount = 0;
            for (int j = 0; j < columnLength; j++) {
                flip[j] = 1 ^ matrix[i][j];
            }
            for (int k = 0; k < rowLength; k++) {
                if (Arrays.equals(matrix[k], matrix[i]) || Arrays.equals(matrix[k], flip)) {
                    currentCount++;
                    seen.add(k);
                }
            }

            answer = Math.max(answer, currentCount);
        }

        return answer;
    }
}
