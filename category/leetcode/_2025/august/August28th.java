package category.leetcode._2025.august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class August28th {

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            sortMatrix(i, 0, false, grid);
        }

        for (int j = 1; j < n; j++) {
            sortMatrix(0, j, true, grid);
        }

        return grid;
    }

    private void sortMatrix(int rowIndex, int columnIndex, boolean isIncreseOrder, int[][] grid) {
        int n = grid.length;
        List<Integer> nums = new ArrayList<>();
        int row = rowIndex;
        int col = columnIndex;

        while (row < n && col < n) {
            nums.add(grid[row++][col++]);
        }

        if (isIncreseOrder) {
            Collections.sort(nums);
        } else {
            nums.sort(Comparator.reverseOrder());
        }

        int index = 0;

        for (int num : nums) {
            grid[rowIndex + index][columnIndex + index] = num;
            index++;
        }
    }
}
