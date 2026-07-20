package category.leetcode._2026.july;

import java.util.ArrayList;
import java.util.List;

public class July20th {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int n = rowLen * colLen;
        int idx = (n - (k % n)) % n;

        for (int i = 0; i < rowLen; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < colLen; j++) {
                int rowIdx = idx / colLen;
                int colIdx = idx % colLen;
                row.add(grid[rowIdx][colIdx]);
                idx = (idx + 1) % n;
            }

            answer.add(row);
        }

        return answer;
    }
}
