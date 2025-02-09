package category.leetcode._2025.february;

import java.util.HashMap;
import java.util.Map;

public class February9th {

    public long countBadPairs(final int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int numsLength = nums.length;
        long answer = 0;

        for (int i = 0; i < numsLength; i++) {
            answer += i - map.getOrDefault(nums[i] - i, 0);
            map.merge(nums[i] - i, 1, Integer::sum);
        }

        return answer;
    }
}
