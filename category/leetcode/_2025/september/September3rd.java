package category.leetcode._2025.september;

import java.util.Arrays;
import java.util.Comparator;

public class September3rd {

    public int numberOfPairs(int[][] points) {
        int answer = 0;
        Arrays.sort(points, Comparator.comparingInt((int[] row) -> row[0])
                .thenComparingInt((int[] row) -> -row[1]));
        int n = points.length;

        for (int i = 0; i < n; i++) {
            int[] alice = points[i];
            int maxY = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int[] bob = points[j];

                if (bob[1] <= alice[1] && bob[1] > maxY) {
                    maxY = bob[1];
                    answer++;
                }

            }
        }

        return answer;
    }
}
