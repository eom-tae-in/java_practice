package category.leetcode._2026.march;

public class March25th {

    public boolean canPartitionGrid(int[][] grid) {
        long totalSum = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        long[] rowPrefix = new long[rowLen];
        long[] colPrefix = new long[colLen];

        for (int i = 0; i < rowLen; i++) {
            int rowSum = 0;

            for (int j = 0; j < colLen; j++) {
                int curr = grid[i][j];
                rowSum += curr;
                colPrefix[j] += curr;
                totalSum += curr;
            }

            rowPrefix[i] = rowSum;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        long half = totalSum / 2;

        if (rowPrefix[0] == half || colPrefix[0] == half) {
            return true;
        }

        for (int i = 1; i < rowLen; i++) {
            rowPrefix[i] += rowPrefix[i - 1];

            if (rowPrefix[i] == half) {
                return true;
            }
        }

        for (int j = 1; j < colLen; j++) {
            colPrefix[j] += colPrefix[j - 1];

            if (colPrefix[j] == half) {
                return true;
            }
        }

        return false;
    }
}
