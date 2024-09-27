package category.leetcode._2024.september;

import java.util.Map;
import java.util.TreeMap;

public class September27th {

    private final Map<Integer, Integer> map;

    public September27th() {
        map = new TreeMap<>();
    }

    public boolean book(final int start, final int end) {
        map.merge(start, 1, Integer::sum);
        map.merge(end, -1, Integer::sum);
        int countSum = 0;

        for (int count : map.values()) {
            countSum += count;
            if (countSum > 2) {
                if (map.merge(start, -1, Integer::sum) == 0) {
                    map.remove(start);
                }
                if (map.merge(end, 1, Integer::sum) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }

        return true;
    }
}
