package category.leetcode._2024.August;

public class August9th {

    public int numMagicSquaresInside(final int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int count = 0;
        for (int i = 0; i + 2 < row; i++) {
            for (int j = 0; j + 2 < column; j++) {
                if (isMagicSquare(i, j, grid)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isMagicSquare(final int row, final int column, final int[][] grid) {
        boolean[] isSeen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int current = grid[i + row][j + column];
                if (current < 1 || 9 < current) {
                    return false;
                }
                if (isSeen[current]) {
                    return false;
                }
                isSeen[current] = true;
            }
        }

        return isBothDiagonalsSumSame(row, column, grid)
                && isRowsSumSame(row, column, grid)
                && isColumnSumSame(row, column, grid);
    }

    private boolean isBothDiagonalsSumSame(final int row, final int column, final int[][] grid) {
        int diagonal1 = grid[row][column + 2] + grid[row + 1][column + 1] + grid[row + 2][column];
        int diagonal2 = grid[row][column] + grid[row + 1][column + 1] + grid[row + 2][column + 2];

        return diagonal1 == diagonal2;
    }

    private boolean isRowsSumSame(final int row, final int column, final int[][] grid) {
        int row1 = grid[row][column] + grid[row][column + 1] + grid[row][column + 2];
        int row2 = grid[row + 1][column] + grid[row + 1][column + 1] + grid[row + 1][column + 2];
        int row3 = grid[row + 2][column] + grid[row + 2][column + 1] + grid[row + 2][column + 2];

        return row1 == row2 && row2 == row3;
    }

    private boolean isColumnSumSame(final int row, final int column, final int[][] grid) {
        int column1 = grid[row][column] + grid[row + 1][column] + grid[row + 2][column];
        int column2 = grid[row][column + 1] + grid[row + 1][column + 1] + grid[row + 2][column + 1];
        int column3 = grid[row][column + 2] + grid[row + 1][column + 2] + grid[row + 2][column + 2];

        return column1 == column2 && column2 == column3;
    }
}
