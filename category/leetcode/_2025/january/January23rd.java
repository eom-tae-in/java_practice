package category.leetcode._2025.january;

public class January23rd {

    public int countServers(final int[][] grid) {
        int answer = 0;
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int[] rows = new int[rowLength];
        int[] columns = new int[columnLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    columns[j]++;
                }
            }
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || columns[j] > 1)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
