package category.leetcode._2026.september;

public class September29th {

    private char[][] grid;
    private int m, n;
    private byte[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int length = m + n - 1;

        if (length % 2 == 1) {
            return false;
        }

        if (grid[0][0] != '(') {
            return false;
        }

        if (grid[m - 1][n - 1] != ')') {
            return false;
        }

        memo = new byte[m][n][length + 1];

        return dfs(0, 0, 0);
    }

    private boolean dfs(int r, int c, int balance) {
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        int remaining = (m - 1 - r) + (n - 1 - c);

        if (balance > remaining) {
            return false;
        }

        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        if (memo[r][c][balance] != 0) {
            return memo[r][c][balance] == 2;
        }

        boolean result = false;

        if (r + 1 < m) {
            result = dfs(r + 1, c, balance);
        }

        if (!result && c + 1 < n) {
            result = dfs(r, c + 1, balance);
        }

        memo[r][c][balance] = (byte) (result ? 2 : 1);

        return result;
    }
}
