package category.leetcode._2025.november;

public class November14th {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] grid = new int[n + 1][n + 1];

        for (int[] query : queries) {
            int leftTopRow = query[0];
            int leftTopCol = query[1];
            int rightBottomRow = query[2];
            int rightBottomCol = query[3];
            grid[leftTopRow][leftTopCol] += 1;
            grid[leftTopRow][rightBottomCol + 1] -= 1;
            grid[rightBottomRow + 1][leftTopCol] -= 1;
            grid[rightBottomRow + 1][rightBottomCol + 1] += 1;
        }

        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curr = grid[i][j];

                if (i > 0) {
                    curr += answer[i - 1][j];
                }

                if (j > 0) {
                    curr += answer[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    curr -= answer[i - 1][j - 1];
                }

                answer[i][j] = curr;
            }
        }

        return answer;
    }
}
