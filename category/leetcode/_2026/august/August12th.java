package category.leetcode._2026.august;

import java.util.HashMap;
import java.util.Map;

public class August12th {

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        int left = 0;
        int answer = 0;

        for (int right = 0; right < n; right++) {
            int curr = nums[right];
            count.merge(curr, 1, Integer::sum);

            if (count.get(curr) > k) {
                answer = Math.max(answer, right - left);

                while (count.get(curr) > k) {
                    count.merge(nums[left++], -1, Integer::sum);
                }
            }
        }

        answer = Math.max(answer, n - left);

        return answer;
    }
}
