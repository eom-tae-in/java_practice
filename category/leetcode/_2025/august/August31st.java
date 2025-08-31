package category.leetcode._2025.august;

public class August31st {

    public void solveSudoku(char[][] board) {
        dfs(0, 0, board);
    }

    private boolean dfs(
            int rowIndex,
            int columnIndex,
            char[][] board
    ) {
        if (rowIndex == 9 && columnIndex == 0) {
            return true;
        }

        if (board[rowIndex][columnIndex] != '.') {
            if (columnIndex == board[0].length - 1) {
                return dfs(rowIndex + 1, 0, board);
            } else {
                return dfs(rowIndex, columnIndex + 1, board);
            }
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(rowIndex, columnIndex, ch, board)) {
                board[rowIndex][columnIndex] = ch;

                if (columnIndex == board[0].length - 1) {
                    if (dfs(rowIndex + 1, 0, board)) {
                        return true;
                    }
                } else {
                    if (dfs(rowIndex, columnIndex + 1, board)) {
                        return true;
                    }
                }

                board[rowIndex][columnIndex] = '.';
            }
        }

        return false;
    }

    private boolean isValid(
            int rowIndex,
            int columnIndex,
            char ch,
            char[][] board
    ) {

        for (int i = 0; i < 9; i++) {
            if (board[i][columnIndex] == ch || board[rowIndex][i] == ch) {
                return false;
            }
        }

        int rowDigit = rowIndex / 3;
        int columnDigit = columnIndex / 3;

        for (int i = rowDigit * 3; i < rowDigit * 3 + 3; i++) {
            for (int j = columnDigit * 3; j < columnDigit * 3 + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }
}
