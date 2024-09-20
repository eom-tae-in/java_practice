package category.leetcode._2024.july;

import java.util.ArrayList;
import java.util.List;

public class July19th {

    public List<Integer> luckyNumbers(final int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        for (int[] row : matrix) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[j] < min) {
                    min = row[j];
                    index = j;
                }
            }
            if (isLuckNumber(min, index, matrix)) {
                answer.add(row[index]);
            }
        }

        return answer;
    }

    private boolean isLuckNumber(final int min, final int column, final int[][] matrix) {
        for (int[] row : matrix) {
            if (min < row[column]) {
                return false;
            }
        }

        return true;
    }
}
