package category.leetcode._2025.march;

import java.util.Arrays;
import java.util.Comparator;

public class March25th {

    public boolean checkValidCuts(final int n, final int[][] rectangles) {
        int[][] xs = new int[rectangles.length][2];
        int[][] ys = new int[rectangles.length][2];

        for (int i = 0; i < rectangles.length; ++i) {
            xs[i][0] = rectangles[i][0];
            xs[i][1] = rectangles[i][2];
            ys[i][0] = rectangles[i][1];
            ys[i][1] = rectangles[i][3];
        }

        return Math.max(countMerged(xs), countMerged(ys)) >= 3;
    }

    private int countMerged(final int[][] intervals) {
        int count = 0;
        int prevEnd = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start < prevEnd) {
                prevEnd = Math.max(prevEnd, end);
            } else {
                prevEnd = end;
                ++count;
            }
        }

        return count;
    }
}
