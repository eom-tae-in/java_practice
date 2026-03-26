package category.leetcode._2026.march;

import java.util.HashMap;
import java.util.Map;

public class March26th {

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long total = 0;
        long[] rowSum = new long[m];
        long[] colSum = new long[n];
        Map<Integer, Integer> minRow = new HashMap<>();
        Map<Integer, Integer> maxRow = new HashMap<>();
        Map<Integer, Integer> minCol = new HashMap<>();
        Map<Integer, Integer> maxCol = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                total += v;
                rowSum[i] += v;
                colSum[j] += v;

                minRow.putIfAbsent(v, i);
                maxRow.put(v, i);

                minCol.putIfAbsent(v, j);
                maxCol.put(v, j);
            }
        }

        long top = 0;

        for (int cut = 0; cut < m - 1; cut++) {
            top += rowSum[cut];
            long bottom = total - top;

            if (top == bottom) {
                return true;
            }

            long diff = Math.abs(top - bottom);

            if (top > bottom) {
                if (canRemoveRowRange(grid, 0, cut, diff, minRow, true)) {
                    return true;
                }
            } else {
                if (canRemoveRowRange(grid, cut + 1, m - 1, diff, maxRow, false)) {
                    return true;
                }
            }
        }

        long left = 0;

        for (int cut = 0; cut < n - 1; cut++) {
            left += colSum[cut];
            long right = total - left;

            if (left == right) {
                return true;
            }

            long diff = Math.abs(left - right);

            if (left > right) {
                if (canRemoveColRange(grid, 0, cut, diff, minCol, true)) {
                    return true;
                }
            } else {
                if (canRemoveColRange(grid, cut + 1, n - 1, diff, maxCol, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canRemoveRowRange(
            int[][] grid,
            int startRow,
            int endRow,
            long diff,
            Map<Integer, Integer> rowMap,
            boolean useMinBoundary
    ) {
        if (diff > Integer.MAX_VALUE) {
            return false;
        }

        int target = (int) diff;
        int height = endRow - startRow + 1;
        int width = grid[0].length;

        if (height == 1 && width == 1) {
            return false;
        }

        if (height == 1) {
            return grid[startRow][0] == target || grid[startRow][width - 1] == target;
        }

        if (width == 1) {
            return grid[startRow][0] == target || grid[endRow][0] == target;
        }

        Integer row = rowMap.get(target);

        if (row == null) {
            return false;
        }

        return useMinBoundary ? row <= endRow : row >= startRow;
    }

    private boolean canRemoveColRange(
            int[][] grid,
            int startCol,
            int endCol,
            long diff,
            Map<Integer, Integer> colMap,
            boolean useMinBoundary
    ) {
        if (diff > Integer.MAX_VALUE) {
            return false;
        }

        int target = (int) diff;
        int height = grid.length;
        int width = endCol - startCol + 1;

        if (height == 1 && width == 1) {
            return false;
        }

        if (height == 1) {
            return grid[0][startCol] == target || grid[0][endCol] == target;
        }

        if (width == 1) {
            return grid[0][startCol] == target || grid[height - 1][startCol] == target;
        }

        Integer col = colMap.get(target);

        if (col == null) {
            return false;
        }

        return useMinBoundary ? col <= endCol : col >= startCol;
    }
}
