package category.leetcode._2026.march;

public class March4th {

    public int numSpecial(int[][] mat) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[] rowSum = new int[rowLen];
        int[] colSum = new int[colLen];
        int answer = 0;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int curr = mat[i][j];
                rowSum[i] += curr;
                colSum[j] += curr;
            }
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
