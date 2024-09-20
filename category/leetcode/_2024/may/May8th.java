package category.leetcode._2024.may;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class May8th {

    private static final String FIRST_PRIZE = "Gold Medal";
    private static final String SECOND_PRIZE = "Silver Medal";
    private static final String THIRD_PRIZE = "Bronze Medal";

    public String[] findRelativeRanks(final int[] score) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        String[] result = new String[score.length];
        int count = 1;

        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (count == 1) {
                result[entry.getValue()] = FIRST_PRIZE;
            } else if (count == 2) {
                result[entry.getValue()] = SECOND_PRIZE;
            } else if (count == 3) {
                result[entry.getValue()] = THIRD_PRIZE;
            } else {
                result[entry.getValue()] = String.valueOf(count);
            }
            count++;
        }

        return result;
    }
}
