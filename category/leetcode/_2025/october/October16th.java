package category.leetcode._2025.october;

import java.util.HashMap;
import java.util.Map;

public class October16th {

    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> count = new HashMap<>();

        for (final int num : nums) {
            count.merge((num % value + value) % value, 1, Integer::sum);
        }

        for (int i = 0; i < nums.length; ++i) {
            if (count.getOrDefault(i % value, 0) == 0) {
                return i;
            }
            count.merge(i % value, -1, Integer::sum);
        }

        return nums.length;
    }
}
