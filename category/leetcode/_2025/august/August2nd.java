package category.leetcode._2025.august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class August2nd {

    public long minCost(int[] basket1, int[] basket2) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int num : basket1) {
            map.merge(num, 1, Integer::sum);
            min = Math.min(min, num);
        }

        for (int num : basket2) {
            map.merge(num, -1, Integer::sum);
            min = Math.min(min, num);
        }

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();

            if (value % 2 != 0) {
                return -1;
            }

            int count = Math.abs(value) / 2;

            while (count-- > 0) {
                list.add(entry.getKey());
            }
        }

        int loopCount = list.size() / 2;
        Collections.sort(list);

        for (int i = 0; i < loopCount; i++) {
            answer += Math.min(min * 2, list.get(i));
        }

        return answer;
    }
}
