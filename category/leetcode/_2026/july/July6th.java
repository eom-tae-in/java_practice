package category.leetcode._2026.july;

import java.util.Arrays;
import java.util.Comparator;

public class July6th {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[0])
                .thenComparingInt((int[] interval) -> -interval[1]));
        int answer = 0;
        int prevEnd = 0;

        for (int[] interval : intervals) {
            if (prevEnd < interval[1]) {
                prevEnd = interval[1];
                answer++;
            }
        }

        return answer;
    }
}
