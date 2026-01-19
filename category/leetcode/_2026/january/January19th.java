package category.leetcode._2026.january;

public class January19th {

    public int maxSideLength(int[][] mat, int threshold) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[][] prefix = new int[rowLen + 1][colLen + 1];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + mat[i][j];
            }
        }

        int left = 1;
        int right = Math.min(rowLen, colLen);

        while (left <= right) {
            int mid = (left + right) / 2;

            if (hasLessOrEqualSum(mid, threshold, prefix)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private boolean hasLessOrEqualSum(int len, int threshold, int[][] prefix) {
        int rowLen = prefix.length - 1;
        int colLen = prefix[0].length - 1;

        for (int i = 0; i <= rowLen - len; i++) {
            for (int j = 0; j <= colLen - len; j++) {
                int curr = prefix[i + len][j + len] - prefix[i + len][j] - prefix[i][j + len] + prefix[i][j];

                if (curr <= threshold) {
                    return true;
                }
            }
        }

        return false;
    }
}
