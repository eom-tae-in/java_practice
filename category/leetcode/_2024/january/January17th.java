package category.leetcode._2024.january;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class January17th {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (final int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == map.size();
    }
}
