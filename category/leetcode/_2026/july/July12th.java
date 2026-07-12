package category.leetcode._2026.july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class July12th {

    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        int[] copy = arr.clone();
        Arrays.sort(copy);

        for (int num : copy) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            answer[i] = map.get(arr[i]);
        }

        return answer;
    }
}
