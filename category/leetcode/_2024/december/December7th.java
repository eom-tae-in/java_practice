package category.leetcode._2024.december;

import java.util.Arrays;

public class December7th {

    public int minimumSize(final int[] nums, final int maxOperations) {
        int min = 1;
        int max = Arrays.stream(nums)
                .max()
                .getAsInt();

        while (min < max) {
            int mid = (min + max) / 2;

            if (calculatePenalty(nums, mid) <= maxOperations) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private int calculatePenalty(final int[] nums, final int mid) {
        int operations = 0;

        for (int num : nums) {
            operations += (num - 1) / mid;
        }

        return operations;
    }
}
