package category.leetcode._2025.august;

public class August26th {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxLength = 0;
        int maxWidth = 0;
        double maxDiagonal = 0;

        for (int[] dimension : dimensions) {
            double curr = Math.sqrt(dimension[0] * dimension[0] + dimension[1] * dimension[1]);

            if (curr > maxDiagonal) {
                maxDiagonal = curr;
                maxLength = dimension[0];
                maxWidth = dimension[1];
            } else if (curr == maxDiagonal && dimension[0] * dimension[1] > maxLength * maxWidth) {
                maxLength = dimension[0];
                maxWidth = dimension[1];
            }
        }

        return maxLength * maxWidth;
    }
}
