package category.leetcode._2025.december;

import java.util.HashMap;
import java.util.Map;

public class December9th {

    public int specialTriplets(int[] nums) {
        int mod = 1_000_000_007;
        int n = nums.length;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        long answer = 0;

        // initialize left
        left.merge(nums[0], 1, Integer::sum);

        // initialize right
        for (int i = 1; i < n; i++) {
            right.merge(nums[i], 1, Integer::sum);
        }

        for (int mid = 1; mid < n - 1; mid++) {
            int curr = nums[mid];
            int target = curr * 2;
            right.compute(curr, (key, value) -> value == 1 ? null : value - 1);

            if (left.containsKey(target) && right.containsKey(target)) {
                answer = (answer + (long) left.get(target) * right.get(target)) % mod;
            }

            left.merge(curr, 1, Integer::sum);
        }

        return (int) answer;
    }
}
