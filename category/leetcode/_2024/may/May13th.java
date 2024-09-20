package category.leetcode._2024.may;

public class May13th {

    public int matrixScore(final int[][] grid) {
        int answer = 0;
        int rowSize = grid.length;
        int columnSize = grid[0].length;

        for (int[] row : grid) {
            if (row[0] == 0) {
                flip(row);
            }
        }

        for (int i = 0; i < columnSize; i++) {
            if (calculateColumn(grid, i) * 2 < rowSize) {
                flipColumn(grid, i);
            }
        }

        for (int[] row : grid) {
            answer += calculateRowSum(row);
        }

        return answer;
    }

    private void flip(final int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] ^= 1;
        }
    }

    private int calculateColumn(final int[][] grid, final int columnIndex) {
        int sum = 0;
        for (int[] row : grid) {
            sum += row[columnIndex];
        }

        return sum;
    }

    private void flipColumn(final int[][] grid, final int columnIndex) {
        for (int j = 0; j < grid.length; j++) {
            grid[j][columnIndex] ^= 1;
        }
    }

    private int calculateRowSum(final int[] row) {
        int sum = row[0];
        for (int i = 1; i < row.length; i++) {
            sum = sum * 2 + row[i];
        }

        return sum;
    }
}
