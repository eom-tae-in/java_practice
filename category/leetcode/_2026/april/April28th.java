package category.leetcode._2026.april;

import java.util.Arrays;

public class April28th {

    public int minOperations(int[][] grid, int x) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int[] nums = new int[rowLength * columnLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                nums[i * columnLength + j] = grid[i][j];
            }
        }

        if (isInvalidCase(nums, x)) {
            return -1;
        }

        Arrays.sort(nums);

        return Arrays.stream(nums)
                .map(num -> Math.abs(num - nums[nums.length / 2]) / x)
                .sum();
    }

    private boolean isInvalidCase(int[] nums, int x) {
        return Arrays.stream(nums)
                .anyMatch(num -> (num - nums[0]) % x != 0);
    }
}
