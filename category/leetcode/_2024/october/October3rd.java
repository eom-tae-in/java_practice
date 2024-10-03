package category.leetcode._2024.october;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class October3rd {

    public int minSubarray(final int[] nums, final int p) {
        long sum = Arrays.stream(nums)
                .asLongStream()
                .sum();
        int remainder = (int) (sum % p);
        if (remainder == 0) {
            return 0;
        }
        int prefix = 0;
        int answer = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            prefix %= p;
            int target = (prefix - remainder + p) % p;
            if (map.containsKey(target)) {
                answer = Math.min(answer, i - map.get(target));
            }
            map.put(prefix, i);
        }

        return answer == nums.length ? -1 : answer;
    }
}
