package category.leetcode._2025.january;

public class January20th {

    public int firstCompleteIndex(final int[] arr, final int[][] mat) {
        int rowLength = mat.length;
        int columnLength = mat[0].length;
        int[] rows = new int[rowLength];
        int[] columns = new int[columnLength];
        int[] rowIndices = new int[rowLength * columnLength + 1];
        int[] columnIndices = new int[rowLength * columnLength + 1];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                rowIndices[mat[i][j]] = i;
                columnIndices[mat[i][j]] = j;
            }
        }

        int arrLength = arr.length;

        for (int i = 0; i < arrLength; i++) {
            int current = arr[i];
            int row = rowIndices[current];
            int column = columnIndices[current];

            if (++rows[row] == columnLength) {
                return i;
            }

            if (++columns[column] == rowLength) {
                return i;
            }
        }

        return 0;
    }
}
