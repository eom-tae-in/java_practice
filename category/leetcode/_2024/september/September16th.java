package category.leetcode._2024.september;

import java.util.List;

public class September16th {

    public int findMinDifference(final List<String> timePoints) {
        int answer = 24 * 60;
        int first = 24 * 60;
        boolean[] bucket = new boolean[24 * 60];
        for (String timePoint : timePoints) {
            int num = Integer.parseInt(timePoint.substring(0, 2)) * 60 + Integer.parseInt(timePoint.substring(3));
            first = Math.min(first, num);
            if (bucket[num]) {
                return 0;
            }
            bucket[num] = true;
        }
        int prev = first;
        for (int i = first + 1; i < bucket.length; ++i) {
            if (bucket[i]) {
                answer = Math.min(answer, i - prev);
                prev = i;
            }
        }

        return Math.min(answer, 24 * 60 - prev + first);
    }
}
