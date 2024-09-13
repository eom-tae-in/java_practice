package category.leetcode._2024.september;

import java.util.HashMap;
import java.util.Map;

public class September13th {

    public int[] xorQueries(final int[] arr, final int[][] queries) {
        Map<Range, Integer> map = new HashMap<>();
        int length = queries.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            Range current = new Range(left, right);
            if (map.containsKey(current)) {
                answer[i] = map.get(current);
            } else {
                int xor = calculateXor(arr, left, right);
                map.put(new Range(left, right), xor);
                answer[i] = xor;
            }
        }

        return answer;
    }

    record Range(int left, int right) {
    }

    private int calculateXor(int[] arr, int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            result ^= arr[i];
        }

        return result;
    }
}
