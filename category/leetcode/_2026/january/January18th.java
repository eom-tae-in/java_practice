package category.leetcode._2026.january;

public class January18th {

    public int largestMagicSquare(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] rowPrefix = new int[rowLen][colLen + 1];
        int[][] colPrefix = new int[rowLen + 1][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int curr = grid[i][j];
                rowPrefix[i][j + 1] = rowPrefix[i][j] + curr;
                colPrefix[i + 1][j] = colPrefix[i][j] + curr;
            }
        }

        int maxLen = Math.min(rowLen, colLen);

        for (int len = maxLen; len >= 2; len--) {
            for (int i = 0; i <= rowLen - len; i++) {
                for (int j = 0; j <= colLen - len; j++) {
                    if (isMagicSquare(i, j, len, rowPrefix, colPrefix, grid)) {
                        return len;
                    }
                }
            }
        }

        return 1;
    }

    private boolean isMagicSquare(
            int rowIdx,
            int colIdx,
            int len,
            int[][] rowPrefix,
            int[][] colPrefix,
            int[][] grid
    ) {
        int target = rowPrefix[rowIdx][colIdx + len] - rowPrefix[rowIdx][colIdx];

        if (hasInvalidRowSum(rowIdx, colIdx, len, rowPrefix, target)) {
            return false;
        }

        if (hasInvalidColSum(rowIdx, colIdx, len, colPrefix, target)) {
            return false;
        }

        if (hasInvalidDiagSum(rowIdx, colIdx, len, grid, target)) {
            return false;
        }

        return true;
    }

    private boolean hasInvalidRowSum(
            int rowIdx,
            int colIdx,
            int len,
            int[][] rowPrefix,
            int target
    ) {
        for (int i = rowIdx; i < rowIdx + len; i++) {
            int curr = rowPrefix[i][colIdx + len] - rowPrefix[i][colIdx];

            if (curr != target) {
                return true;
            }
        }

        return false;
    }

    private boolean hasInvalidColSum(
            int rowIdx,
            int colIdx,
            int len,
            int[][] colPrefix,
            int target
    ) {
        for (int j = colIdx; j < colIdx + len; j++) {
            int curr = colPrefix[rowIdx + len][j] - colPrefix[rowIdx][j];

            if (curr != target) {
                return true;
            }
        }

        return false;
    }

    private boolean hasInvalidDiagSum(
            int rowIdx,
            int colIdx,
            int len,
            int[][] grid,
            int target
    ) {
        int primaryDiagSum = 0;
        int secondaryDiagSum = 0;
        int reverseIdx = colIdx + len - 1;
        int idx = colIdx;

        for (int i = rowIdx; i < rowIdx + len; i++) {
            primaryDiagSum += grid[i][idx++];
            secondaryDiagSum += grid[i][reverseIdx--];
        }

        return (primaryDiagSum != target) || (secondaryDiagSum != target);
    }
}
