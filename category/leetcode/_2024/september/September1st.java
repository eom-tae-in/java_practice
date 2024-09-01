package category.leetcode._2024.september;

public class September1st {

    public int[][] construct2DArray(final int[] original, final int m, final int n) {
        int length = original.length;
        if (m * n != length) {
            return new int[0][];
        }
        int[][] answer = new int[m][n];
        for (int i = 0; i < length; i++) {
            answer[i / n][i % n] = original[i];
        }

        return answer;
    }
}
