package category.leetcode._2025.february;

import java.util.HashMap;
import java.util.Map;

public class February6th {

    public int tupleSameProduct(final int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int numsLength = nums.length;

        for (int i = 0; i < numsLength - 1; i++) {
            for (int j = i + 1; j < numsLength; j++) {
                int current = nums[i] * nums[j];
                answer += map.getOrDefault(current, 0) * 8;
                map.merge(current, 1, Integer::sum);
            }
        }

        return answer;
    }
}
