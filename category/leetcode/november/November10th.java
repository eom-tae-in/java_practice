package category.leetcode.november;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class November10th {

    public int[] restoreArray(int[][] adjacentPairs) {
        int[] ans = new int[adjacentPairs.length + 1];
        int i = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pair : adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                ans[i++] = entry.getKey();
                ans[i++] = entry.getValue().get(0);
                break;
            }
        }

        while (i < adjacentPairs.length + 1) {
            final int tail = ans[i - 1];
            final int prev = ans[i - 2];
            List<Integer> list = map.get(tail);
            if (list.get(0) == prev) {
                ans[i++] = list.get(1);
            } else {
                ans[i++] = list.get(0);
            }
        }

        return ans;
    }
}
