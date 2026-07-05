package category.leetcode._2026.july;

import java.util.Arrays;
import java.util.List;

public class July5th {

    private static final int MOD = 1_000_000_007;
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {1, 1}};

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] dp = new int[n + 1][n + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        int[][] count = new int[n + 1][n + 1];
        dp[0][0] = 0;
        dp[n - 1][n - 1] = 0;
        count[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'S' || board.get(i).charAt(j) == 'X') {
                    continue;
                }

                for (int[] dir : DIRS) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (dp[i][j] < dp[x][y]) {
                        dp[i][j] = dp[x][y];
                        count[i][j] = count[x][y];
                    } else if (dp[i][j] == dp[x][y]) {
                        count[i][j] += count[x][y];
                        count[i][j] %= MOD;
                    }
                }

                if (dp[i][j] != -1 && board.get(i).charAt(j) != 'E') {
                    dp[i][j] += board.get(i).charAt(j) - '0';
                    dp[i][j] %= MOD;
                }
            }
        }

        return new int[]{dp[0][0], count[0][0]};
    }
}
