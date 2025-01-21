package category.leetcode._2025.january;

public class January21st {

    public long gridGame(final int[][] grid) {
        int loopCount = grid[0].length;
        long sumRow0 = 0;
        long sumRow1 = 0;
        long answer = Long.MAX_VALUE;

        for (int i = 0; i < loopCount; i++) {
            sumRow0 += grid[0][i];
        }

        for (int i = 0; i < loopCount; i++) {
            sumRow0 -= grid[0][i];
            answer = Math.min(answer, Math.max(sumRow0, sumRow1));
            sumRow1 += grid[1][i];
        }

        return answer;
    }
}
