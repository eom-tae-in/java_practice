package category.leetcode._2024.June;

import java.util.Arrays;

public class June10th {

    public int heightChecker(final int[] heights) {
        int answer = 0;
        int n = heights.length;
        int[] sortedHeights = Arrays.copyOf(heights, n);
        Arrays.sort(sortedHeights);
        for (int i = 0; i < n; i++) {
            if (isNotSame(heights[i], sortedHeights[i])) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isNotSame(final int height, final int sortedHeight) {
        return height != sortedHeight;
    }
}
