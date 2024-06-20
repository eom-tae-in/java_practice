package category.leetcode._2024.June;

import java.util.Arrays;

public class June20th {

    public int maxDistance(final int[] position, final int m) {
        Arrays.sort(position);
        int n = position.length;
        int left = 1;
        int right = position[n - 1] - position[0];
        while (left < right) {
            int middle = right - (right - left) / 2;
            if (canDistributeBalls(position, middle, m)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private boolean canDistributeBalls(final int[] position, final int middle, final int ballCount) {
        int count = 0;
        int prevPosition = -middle;
        for (int pos : position) {
            if (pos - prevPosition >= middle) {
                count++;
                prevPosition = pos;
            }
            if (count == ballCount) {
                return true;
            }
        }

        return false;
    }
}
