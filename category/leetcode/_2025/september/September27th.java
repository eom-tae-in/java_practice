package category.leetcode._2025.september;

public class September27th {

    public double largestTriangleArea(int[][] points) {
        double answer = 0;
        int n = points.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    answer = Math.max(answer, 0.5 * Math.abs(getTriangleArea(points, j, i, k)));
                }
            }
        }

        return answer;
    }

    private static int getTriangleArea(int[][] points, int j, int i, int k) {
        return (points[j][0] - points[i][0]) * (points[k][1] - points[i][1]) -
                (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]);
    }
}
