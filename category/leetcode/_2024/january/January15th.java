package category.leetcode._2024.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class January15th {

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        Map<Integer, Integer> lossesCount = new TreeMap<>();

        for (int[] m : matches) {
            final int winner = m[0];
            final int loser = m[1];
            lossesCount.putIfAbsent(winner, 0);
            lossesCount.merge(loser, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : lossesCount.entrySet()) {
            final int lossCount = entry.getValue();
            if (lossCount < 2) {
                ans.get(lossCount).add(entry.getKey());
            }
        }

        return ans;
    }
}
