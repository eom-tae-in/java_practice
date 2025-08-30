package category.leetcode._2025.august;

public class August30th {

    private static final int SIZE = 9;

    public boolean isValidSudoku(char[][] board) {
        int[] rowMask = new int[SIZE];
        int[] colMask = new int[SIZE];
        int[] boxMask = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                char current = board[i][j];

                if (current == '.') {
                    continue;
                }

                int num = board[i][j] - '1';
                int mask = 1 << num;

                if ((rowMask[i] & mask) != 0) {
                    return false;
                }

                rowMask[i] |= mask;

                if ((colMask[j] & mask) != 0) {
                    return false;
                }

                colMask[j] |= mask;
                int boxIndex = (i / 3) * 3 + j / 3;

                if ((boxMask[boxIndex] & mask) != 0) {
                    return false;
                }

                boxMask[boxIndex] |= mask;
            }
        }

        return true;
    }
}
