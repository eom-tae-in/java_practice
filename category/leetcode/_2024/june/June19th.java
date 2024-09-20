package category.leetcode._2024.june;

import java.util.Arrays;

public class June19th {

    public int minDays(final int[] bloomDay, final int m, final int k) {
        int n = bloomDay.length;
        if (n < (long) m * k) {
            return -1;
        }

        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();
        while (left < right) {
            int middle = (left + right) / 2;
            if (canMakeBouquets(bloomDay, k, m, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private boolean canMakeBouquets(final int[] bloomDay, final int k, final int m, final int waitingDay) {
        int count = 0;
        int requiredFlowers = k;
        for (int day : bloomDay) {
            if (day > waitingDay) {
                requiredFlowers = k;
            } else if (--requiredFlowers == 0) {
                count++;
                requiredFlowers = k;
            }
            if (count >= m) {
                return true;
            }
        }

        return false;
    }
}
