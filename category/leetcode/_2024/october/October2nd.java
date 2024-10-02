package category.leetcode._2024.october;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class October2nd {

    public int[] arrayRankTransform(final int[] arr) {
        int[] sortedArr = arr.clone();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(sortedArr);

        for (int num : sortedArr) {
            map.putIfAbsent(num, map.size() + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
