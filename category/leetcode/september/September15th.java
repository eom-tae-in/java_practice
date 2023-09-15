package category.leetcode.september;

import java.util.Arrays;

public class September15th {
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        int[] distance = new int[size];
        int answer = 0;
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                distance[j] = Math.min(distance[j],
                        Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                if (distance[j] < distance[i + 1]) {
                    int[] temArr = points[j];
                    points[j] = points[i + 1];
                    points[i + 1] = temArr;
                    int tem = distance[j];
                    distance[j] = distance[i + 1];
                    distance[i + 1] = tem;
                }
            }
            answer += distance[i + 1];
        }
        return answer;
    }
}
