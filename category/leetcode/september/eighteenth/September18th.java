package category.leetcode.september.eighteenth;

import java.util.Arrays;
import java.util.stream.IntStream;

public class September18th {

    public int[] kWeakestRows(int[][] mat, int k) {
        int rowLength = mat.length;
        int[] answer = new int[k];
        int[][] rowsInfo = new int[rowLength][2];
        for (int i = 0; i < rowLength; i++) {
            rowsInfo[i][0] = IntStream.of(mat[i]).sum();
            rowsInfo[i][1] = i;
        }
        Arrays.sort(rowsInfo, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            answer[i] = rowsInfo[i][1];
        }
        return answer;
    }
}
