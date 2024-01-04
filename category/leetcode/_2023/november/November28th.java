package category.leetcode._2023.november;

import java.util.Arrays;

public class November28th {

    public int knightDialer(int n) {
        int answer = 0;
        int mod = 1_000_000_007;
        int[][] dirs = {{2, 1}, {2, -1}, {1, -2}, {1, 2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};
        int[][] dial = new int[4][3];

        Arrays.stream(dial)
                .forEach(row -> Arrays.fill(row, 1));

        dial[3][0] = dial[3][2] = 0;

        for (int i = 2; i <= n; i++) {
            int[][] current = new int[4][3];
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    if (isNotNumeric(j, k)) {
                        continue;
                    }
                    for (int[] dir : dirs) {
                        int cj = dir[0] + j;
                        int ck = dir[1] + k;
                        if (cj >= 4 || cj < 0 || ck >= 3 || ck < 0) {
                            continue;
                        }
                        if (isNotNumeric(cj, ck)) {
                            continue;
                        }
                        current[j][k] = (current[j][k] + dial[cj][ck]) % mod;
                    }
                }
            }
            dial = current;
        }

        for (int[] row : dial) {
            for (int column : row) {
                answer = (answer + column) % mod;
            }
        }

        return answer;
    }

    private boolean isNotNumeric(final int row, final int column) {
        return row == 3 && (column == 0 || column == 2);
    }
}
