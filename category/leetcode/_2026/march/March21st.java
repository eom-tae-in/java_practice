package category.leetcode._2026.march;

public class March21st {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int sc = y;
        int ec = y + k - 1;
        int sr = x;

        for (int j = sc; j <= ec; j++) {
            for (int i = 0; i < k / 2; i++) {
                int tmp = grid[sr + i][j];
                grid[sr + i][j] = grid[sr + k - i - 1][j];
                grid[sr + k - i - 1][j] = tmp;
            }
        }
        return grid;
    }
}
