package category.leetcode._2025.april;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class April25th {

    public long countInterestingSubarrays(
            final List<Integer> nums,
            final int modulo,
            final int k
    ) {
        long answer = 0;
        int prefix = 0;
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        for (int num : nums) {
            if (num % modulo == k) {
                prefix = (prefix + 1) % modulo;
            }

            answer += prefixCount.getOrDefault((prefix - k + modulo) % modulo, 0);
            prefixCount.merge(prefix, 1, Integer::sum);
        }

        return answer;
    }
}
