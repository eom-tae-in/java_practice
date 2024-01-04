package category.leetcode._2024.January;

import java.util.HashMap;
import java.util.Map;

public class January4th {

    public int minOperations(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> countTable = new HashMap<>();

        for (final int num : nums) {
            countTable.merge(num, 1, Integer::sum);
        }

        for (final int frequency : countTable.values()) {
            if (frequency == 1) {
                return -1;
            }
            answer += (frequency + 2) / 3;
        }

        return answer;
    }
}
