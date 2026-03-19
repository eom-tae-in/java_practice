package category.leetcode._2026.march;

public class March19th {

    public int numberOfSubmatrices(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] prefixX = new int[rowLen + 1][colLen + 1];
        int[][] prefixY = new int[rowLen + 1][colLen + 1];
        int answer = 0;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                char curr = grid[i][j];
                int statusX = 0;
                int statusY = 0;

                if (curr == 'X') {
                    statusX = 1;
                } else if (curr == 'Y') {
                    statusY = 1;
                }

                prefixX[i + 1][j + 1] = prefixX[i + 1][j] + prefixX[i][j + 1] - prefixX[i][j] + statusX;
                prefixY[i + 1][j + 1] = prefixY[i + 1][j] + prefixY[i][j + 1] - prefixY[i][j] + statusY;

                if (prefixX[i + 1][j + 1] > 0 && prefixX[i + 1][j + 1] == prefixY[i + 1][j + 1]) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
