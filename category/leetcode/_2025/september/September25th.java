package category.leetcode._2025.september;

import java.util.List;

public class September25th {

    public int minimumTotal(List<List<Integer>> triangle) {
        int rowLength = triangle.size();
        int maxColumnLength = triangle.get(triangle.size() - 1).size();
        int[][] memory = new int[rowLength + 1][maxColumnLength + 1];

        for (int i = rowLength - 1; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            for (int j = 0; j < currentRow.size(); j++) {
                memory[i][j] = Math.min(memory[i + 1][j + 1], memory[i + 1][j]) + currentRow.get(j);
            }
        }

        return memory[0][0];
    }
}
