package category.leetcode._2024.june;

import java.util.HashMap;
import java.util.Map;

public class June8th {

    public boolean checkSubarraySum(final int[] nums, final int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (map.containsKey(sum)) {
                if (isGoodSubarrayCondition(map.get(sum), i)) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }

    private boolean isGoodSubarrayCondition(final int left, final int right) {
        return right - left > 1;
    }
}
