package category.leetcode._2025.september;

import java.util.Arrays;
import java.util.Comparator;

public class September2nd {

    public int numberOfPairs(int[][] points) {
        int answer = 0;

        Arrays.sort(points, Comparator.comparingInt((int[] row) -> row[0])
                .thenComparingInt((int[] row) -> -row[1]));

        for (int i = 0; i < points.length; i++) {
            int maxY = Integer.MIN_VALUE;

            for (int j = i + 1; j < points.length; j++) {
                if (points[i][1] >= points[j][1] && points[j][1] > maxY) {
                    answer++;
                    maxY = points[j][1];
                }
            }
        }

        return answer;
    }
}
