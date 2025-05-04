package category.leetcode._2025.may;

import java.util.HashMap;
import java.util.Map;

public class May4th {

    public int numEquivDominoPairs(final int[][] dominoes) {
        int answer = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int[] domino : dominoes) {
            int key = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);
            answer += count.getOrDefault(key, 0);
            count.merge(key, 1, Integer::sum);
        }

        return answer;
    }
}
