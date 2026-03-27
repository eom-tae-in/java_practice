package category.leetcode._2026.march;

public class March27th {

    public boolean areSimilar(int[][] mat, int k) {
        for (int[] row : mat) {
            int rowLen = row.length;

            for (int j = 0; j < rowLen; j++) {
                if (row[j] != row[(j + k) % rowLen]) {
                    return false;
                }
            }
        }

        return true;
    }
}
