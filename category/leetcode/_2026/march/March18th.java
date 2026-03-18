package category.leetcode._2026.march;

public class March18th {

    public int countSubmatrices(int[][] grid, int k) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] prefix = new int[rowLen + 1][colLen + 1];
        int answer = 0;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                prefix[i + 1][j + 1] = grid[i][j] + prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j];

                if (prefix[i + 1][j + 1] <= k) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
