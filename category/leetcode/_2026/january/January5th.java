package category.leetcode._2026.january;

public class January5th {

    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 0) {
                    negativeCount++;
                    num *= -1;
                }

                if (min > num) {
                    min = num;
                }

                sum += num;
            }
        }

        if (negativeCount % 2 == 0) {
            return sum;
        } else {
            return sum - min * 2L;
        }
    }
}
