package category.leetcode._2024.november;

import java.util.HashMap;
import java.util.Map;

public class November19th {

    public long maximumSubarraySum(final int[] nums, final int k) {
        long answer = 0;
        long sum = 0;
        int distinct = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (count.merge(nums[i], 1, Integer::sum) == 1) {
                ++distinct;
            }
            if (i >= k) {
                if (count.merge(nums[i - k], -1, Integer::sum) == 0) {
                    --distinct;
                }
                sum -= nums[i - k];
            }
            if (i >= k - 1 && distinct == k) {
                answer = Math.max(answer, sum);
            }
        }

        return answer;
    }
}
