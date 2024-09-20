package category.leetcode._2024.july;

public class July20th {

    public int[][] restoreMatrix(final int[] rowSum, final int[] colSum) {
        int[][] answer = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                int current = Math.min(rowSum[i], colSum[j]);
                answer[i][j] = current;
                rowSum[i] -= current;
                colSum[j] -= current;
            }
        }

        return answer;
    }
}
