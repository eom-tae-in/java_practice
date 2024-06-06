package category.leetcode._2024.June;

import java.util.Map.Entry;
import java.util.TreeMap;

public class June6th {

    public boolean isNStraightHand(final int[] hand, final int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : hand) {
            map.merge(num, 1, Integer::sum);
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > 0) {
                for (int i = key; i < groupSize + key; i++) {
                    if (map.merge(i, -value, Integer::sum) < 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
