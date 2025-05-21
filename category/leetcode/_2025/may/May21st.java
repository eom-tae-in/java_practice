package category.leetcode._2025.may;

public class May21st {

    public void setZeroes(final int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        boolean[] isZeroRow = new boolean[rowLength];
        boolean[] isZeroColumn = new boolean[columnLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    isZeroRow[i] = true;
                    isZeroColumn[j] = true;
                }
            }
        }

        for (int i = 0; i < rowLength; i++) {
            if (isZeroRow[i]) {
                for (int j = 0; j < columnLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < columnLength; j++) {
            if (isZeroColumn[j]) {
                for (int i = 0; i < rowLength; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
