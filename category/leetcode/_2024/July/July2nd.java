package category.leetcode._2024.July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class July2nd {

    public int[] intersect(final int[] nums1, final int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int num1 : nums1) {
            if (map1.containsKey(num1)) {
                map1.put(num1, map1.get(num1) + 1);
            } else {
                map1.put(num1, 1);
            }
        }
        for (int num2 : nums2) {
            if (map1.containsKey(num2) && map1.get(num2) != 0) {
                map1.put(num2, map1.get(num2) - 1);
                answer.add(num2);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

