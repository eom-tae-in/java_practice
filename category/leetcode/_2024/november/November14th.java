package category.leetcode._2024.november;

import java.util.Arrays;

public class November14th {

    public int minimizedMaximum(final int n, final int[] quantities) {
        int left = 1;
        int right = Arrays.stream(quantities).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;

            if (getCount(quantities, mid) <= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getCount(final int[] quantities, final int mid) {
        int count = 0;
        for (int quantity : quantities) {
            count += (quantity - 1) / mid + 1;
        }

        return count;
    }
}
