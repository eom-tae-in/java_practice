package category.leetcode._2025.august;

public class August22nd {

    public int minimumArea(int[][] grid) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int[] row = new int[columnLength];
        int top = -1;
        int bottom = -1;

        for (int i = 0; i < rowLength; i++) {
            int orSum = 0;

            for (int j = 0; j < columnLength; j++) {
                int current = grid[i][j];
                row[j] |= current;
                orSum |= current;
            }

            if (orSum != 0) {
                if (top == -1) {
                    top = i;
                }

                bottom = i;
            }
        }

        int left = -1;
        int right = 0;

        for (int i = 0; i < columnLength; i++) {
            if (row[i] == 1) {
                if (left == -1) {
                    left = i;
                }

                right = i;
            }
        }

        return (right - left + 1) * (bottom - top + 1);
    }
}
