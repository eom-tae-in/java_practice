package category.leetcode._2025.november;

import java.util.HashMap;
import java.util.Map;

public class November30th {

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int rest = (int) (sum % p);

        if (rest == 0) {
            return 0;
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        long accumulate = 0;
        int answer = n;

        for (int i = 0; i < n; i++) {
            accumulate = (accumulate + nums[i]) % p;
            long target = (accumulate - rest + p) % p;

            if (map.containsKey(target)) {
                answer = Math.min(answer, i - map.get(target));
            }

            map.put(accumulate, i);
        }

        return answer == n ? -1 : answer;
    }
}
