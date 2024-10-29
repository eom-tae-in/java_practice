package category.leetcode._2024.october;

public class October29th {

    private int[][] dp;

    public int maxMoves(final int[][] grid) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int answer = 0;
        dp = new int[rowLength][columnLength];

        for (int i = 0; i < rowLength; i++) {
            answer = Math.max(answer, dfs(i, 0, grid[i][0], grid) - 1);
        }

        return answer;
    }

    private int dfs(final int rowIndex, final int columnIndex, final int prevNum, final int[][] grid) {
        if (isInvalidCase(rowIndex, columnIndex, prevNum, grid)) {
            return 0;
        }

        if (dp[rowIndex][columnIndex] != 0) {
            return dp[rowIndex][columnIndex];
        }

        int currentNum = grid[rowIndex][columnIndex];
        int top = dfs(rowIndex - 1, columnIndex + 1, currentNum, grid);
        int middle = dfs(rowIndex, columnIndex + 1, currentNum, grid);
        int bottom = dfs(rowIndex + 1, columnIndex + 1, currentNum, grid);
        dp[rowIndex][columnIndex] = 1 + Math.max(top, Math.max(middle, bottom));

        return dp[rowIndex][columnIndex];
    }

    private boolean isInvalidCase(final int rowIndex, final int columnIndex, final int prevNum, final int[][] grid) {
        return rowIndex < 0 ||
                rowIndex >= grid.length ||
                columnIndex < 0 ||
                columnIndex >= grid[0].length ||
                (columnIndex != 0 && grid[rowIndex][columnIndex] <= prevNum);
    }
}
