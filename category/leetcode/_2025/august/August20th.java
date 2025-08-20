package category.leetcode._2025.august;

public class August20th {

    public int countSquares(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int answer = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (j == 0 || i == 0) {
                    answer += matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                    answer += matrix[i][j];
                }
            }
        }

        return answer;
    }
}
