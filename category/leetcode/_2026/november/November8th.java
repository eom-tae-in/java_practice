package category.leetcode._2026.november;

public class November8th {

    public int countServers(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] rowCount = new int[rowLen];
        int[] colCount = new int[colLen];
        int answer = 0;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
