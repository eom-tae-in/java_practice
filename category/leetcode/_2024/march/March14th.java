package category.leetcode._2024.march;

import java.util.HashMap;
import java.util.Map;

public class March14th {

    public int numSubarraysWithSum(final int[] nums, final int goal) {
        int answer = 0;
        int prefix = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        for (int num : nums) {
            prefix += num;
            int key = prefix - goal;
            if (count.containsKey(key)) {
                answer += count.get(key);
            }
            count.merge(prefix, 1, Integer::sum);
        }

        return answer;
    }
}
