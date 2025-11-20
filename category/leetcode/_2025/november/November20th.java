package category.leetcode._2025.november;

import java.util.Arrays;
import java.util.Comparator;

public class November20th {

    public int intersectionSizeTwo(int[][] intervals) {
        int answer = 0;
        int primary = -1;
        int secondary = -1;
        Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[1])
                .thenComparingInt((int[] interval) -> -interval[0]));

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (primary < start) {
                primary = end;
                secondary = end - 1;
                answer += 2;
            } else if (secondary < start) {
                secondary = primary;
                primary = end;
                answer += 1;
            }
        }

        return answer;
    }
}
