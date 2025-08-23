package category.leetcode._2025.august;

public class August23rd {

    public int minimumSum(int[][] grid) {
        int answer = Integer.MAX_VALUE;
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        for (int i = 0; i < rowLength; i++) {
            int top = calculateMinSum(0, columnLength - 1, 0, i, grid);

            for (int j = 0; j < columnLength; j++) {
                answer = Math.min(
                        answer,
                        top +
                                calculateMinSum(0, j, i, rowLength - 1, grid) +
                                calculateMinSum(j + 1, columnLength - 1, i, rowLength - 1, grid)
                );
            }
        }

        for (int i = 0; i < rowLength; i++) {
            int bottom = calculateMinSum(0, columnLength - 1, i, rowLength - 1, grid);

            for (int j = 0; j < columnLength; j++) {
                answer = Math.min(
                        answer,
                        bottom +
                                calculateMinSum(0, j, 0, i - 1, grid) +
                                calculateMinSum(j + 1, columnLength - 1, 0, i - 1, grid)
                );
            }
        }

        for (int j = 0; j < columnLength; j++) {
            int left = calculateMinSum(0, j, 0, rowLength - 1, grid);

            for (int i = 0; i < rowLength; i++) {
                answer = Math.min(
                        answer,
                        left +
                                calculateMinSum(j + 1, columnLength - 1, 0, i, grid) +
                                calculateMinSum(j + 1, columnLength - 1, i + 1, rowLength - 1, grid)
                );
            }
        }

        for (int j = 0; j < columnLength; j++) {
            int right = calculateMinSum(j, columnLength - 1, 0, rowLength - 1, grid);

            for (int i = 0; i < rowLength; i++) {
                answer = Math.min(
                        answer,
                        right +
                                calculateMinSum(0, j - 1, 0, i, grid) +
                                calculateMinSum(0, j - 1, i + 1, rowLength - 1, grid)
                );
            }
        }

        for (int i = 0; i < rowLength; i++) {
            int top = calculateMinSum(0, columnLength - 1, 0, i, grid);

            for (int j = i + 1; j < rowLength; j++) {
                answer = Math.min(
                        answer,
                        top +
                                calculateMinSum(0, columnLength - 1, i + 1, j, grid) +
                                calculateMinSum(0, columnLength - 1, j + 1, rowLength - 1, grid)
                );
            }
        }

        for (int i = 0; i < columnLength; i++) {
            int left = calculateMinSum(0, i, 0, rowLength - 1, grid);

            for (int j = i + 1; j < columnLength; j++) {
                answer = Math.min(
                        answer,
                        left +
                                calculateMinSum(i + 1, j, 0, rowLength - 1, grid) +
                                calculateMinSum(j + 1, columnLength - 1, 0, rowLength - 1, grid)
                );
            }
        }

        return answer;
    }

    private int calculateMinSum(int x1, int x2, int y1, int y2, int[][] grid) {
        int minX = grid.length;
        int maxX = -1;
        int minY = grid[0].length;
        int maxY = -1;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (grid[i][j] == 1) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        return minX == grid.length ? 0 : (maxX - minX + 1) * (maxY - minY + 1);
    }
}
