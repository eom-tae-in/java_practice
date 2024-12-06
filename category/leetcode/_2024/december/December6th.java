package category.leetcode._2024.december;

import java.util.HashSet;
import java.util.Set;

public class December6th {

    public int maxCount(final int[] banned, final int n, final int maxSum) {
        Set<Integer> set = new HashSet<>();

        for (int ban : banned) {
            set.add(ban);
        }

        int currentSum = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                currentSum += i;
                if (currentSum > maxSum) {
                    break;
                }

                count++;
            }
        }

        return count;
    }
}
