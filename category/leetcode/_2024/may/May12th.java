package category.leetcode._2024.may;

public class May12th {

    public int[][] largestLocal(final int[][] grid) {
        int gridRowSize = grid.length;
        int gridColumnSize = grid[0].length;
        int[][] answer = new int[gridRowSize - 2][gridColumnSize - 2];

        for (int i = 1; i < gridRowSize - 1; i++) {
            for (int j = 1; j < gridColumnSize - 1; j++) {
                answer[i - 1][j - 1] = calculateMaxValue(i, j, grid);
            }
        }

        return answer;
    }

    private int calculateMaxValue(final int rowIndex, final int columnIndex, final int[][] grid) {
        int max = 0;
        for (int i = rowIndex - 1; i <= rowIndex + 1; i++) {
            for (int j = columnIndex - 1; j <= columnIndex + 1; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        return max;
    }
}
