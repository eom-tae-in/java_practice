package category.leetcode._2024.november;

import java.util.Arrays;

public class November23rd {

    public char[][] rotateTheBox(final char[][] box) {
        final int m = box.length;
        final int n = box[0].length;
        char[][] answer = new char[n][m];
        Arrays.stream(answer)
                .forEach(row -> Arrays.fill(row, '.'));

        for (int i = 0; i < m; ++i) {
            for (int j = n - 1, k = n - 1; j >= 0; --j) {
                if (box[i][j] != '.') {
                    if (box[i][j] == '*') {
                        k = j;
                    }
                    answer[k--][m - i - 1] = box[i][j];
                }
            }
        }

        return answer;
    }
}
