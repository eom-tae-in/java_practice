package category.leetcode._2026.march;

public class March16th {

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] biggest = new int[3];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int sz = 0; i + sz < m && i - sz >= 0 && j + 2 * sz < n; ++sz) {
                    int sum = sz == 0 ? grid[i][j] : getSum(grid, i, j, sz);
                    applySum(sum, biggest);
                }
            }
        }

        int count = 0;

        for (int j : biggest) {
            if (j != 0) {
                count++;
            }
        }

        int[] answer = new int[count];
        int idx = 0;

        for (int j : biggest) {
            if (j != 0) {
                answer[idx++] = j;
            }
        }

        return answer;
    }

    private void applySum(int sum, int[] answer) {
        if (answer[0] == sum || answer[1] == sum || answer[2] == sum) {
            return;
        }

        if (sum > answer[0]) {
            answer[2] = answer[1];
            answer[1] = answer[0];
            answer[0] = sum;
        } else if (sum > answer[1]) {
            answer[2] = answer[1];
            answer[1] = sum;
        } else if (sum > answer[2]) {
            answer[2] = sum;
        }
    }

    private int getSum(int[][] grid, int i, int j, int sz) {
        int x = i;
        int y = j;
        int sum = 0;

        for (int k = 0; k < sz; ++k) {
            sum += grid[--x][++y];
        }

        for (int k = 0; k < sz; ++k) {
            sum += grid[++x][++y];
        }

        for (int k = 0; k < sz; ++k) {
            sum += grid[++x][--y];
        }

        for (int k = 0; k < sz; ++k) {
            sum += grid[--x][--y];
        }

        return sum;
    }
}
