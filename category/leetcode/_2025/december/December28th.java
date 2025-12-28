package category.leetcode._2025.december;

public class December28th {

    public int countNegatives(int[][] grid) {
        int answer = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] < 0) {
                    answer += colLen - j;
                    break;
                }
            }
        }

        return answer;
    }
}
