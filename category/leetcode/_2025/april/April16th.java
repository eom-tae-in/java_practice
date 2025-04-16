package category.leetcode._2025.april;

import java.util.HashMap;
import java.util.Map;

public class April16th {

    public long countGood(final int[] nums, final int k) {
        long answer = 0;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int left = 0, right = 0; right < nums.length; right++) {
            int current = nums[right];
            Integer value = map.get(current);

            if (value == null) {
                value = 0;
            }

            pairs += value;
            map.put(current, value + 1);

            while (pairs >= k) {
                int n = map.get(nums[left]) - 1;
                if (n == 0) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], n);
                    pairs -= n;
                }

                left++;
            }

            answer += left;
        }

        return answer;
    }
}
