package category.leetcode._2025.march;

import java.util.Arrays;
import java.util.Comparator;

public class March24th {

    public int countDays(final int days, final int[][] meetings) {
        int freeDays = 0;
        int prevEnd = 0;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (start > prevEnd) {
                freeDays += start - prevEnd - 1;
            }

            prevEnd = Math.max(prevEnd, end);
        }

        return freeDays + Math.max(0, days - prevEnd);
    }
}
