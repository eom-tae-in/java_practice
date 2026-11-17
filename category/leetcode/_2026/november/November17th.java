package category.leetcode._2026.november;

import java.util.Arrays;

public class November17th {

    public int minimumChanges(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] cost = new int[n][n];

        for (int length = 2; length <= n; length++) {
            for (int left = 0; left + length <= n; left++) {
                int right = left + length - 1;
                int minChanges = n;

                for (int step = 1; step <= length / 2; step++) {
                    if (length % step != 0) {
                        continue;
                    }

                    int changes = 0;

                    for (int offset = 0; offset < step; offset++) {
                        int first = left + offset;
                        int last = first + length - step;

                        while (first < last) {
                            if (chars[first] != chars[last]) {
                                changes++;
                            }

                            first += step;
                            last -= step;
                        }
                    }

                    minChanges = Math.min(minChanges, changes);
                }

                cost[left][right] = minChanges;
            }
        }

        int inf = n + 1;
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, inf);
        }

        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            for (int end = 2 * parts; end <= n; end++) {
                for (int start = 2 * (parts - 1); start <= end - 2; start++) {
                    dp[parts][end] = Math.min(dp[parts][end], dp[parts - 1][start] + cost[start][end - 1]);
                }
            }
        }

        return dp[k][n];
    }
}
