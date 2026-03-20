package category.leetcode._2026.march;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class March20th {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] answer = new int[rowLen - k + 1][colLen - k + 1];

        for (int i = 0; i <= rowLen - k; i++) {
            for (int j = 0; j <= colLen - k; j++) {
                Set<Integer> set = new HashSet<>();

                for (int m = i; m < i + k; m++) {
                    for (int n = j; n < j + k; n++) {
                        int curr = grid[m][n];
                        set.add(curr);
                    }
                }

                if (set.size() == 1) {
                    answer[i][j] = 0;
                    continue;
                }

                int[] curr = new int[set.size()];
                int idx = 0;

                for (int num : set) {
                    curr[idx++] = num;
                }

                Arrays.sort(curr);
                int min = Integer.MAX_VALUE;

                for (int currIdx = 1; currIdx < curr.length; currIdx++) {
                    min = Math.min(min, curr[currIdx] - curr[currIdx - 1]);
                }

                answer[i][j] = min;
            }
        }

        return answer;
    }
}
