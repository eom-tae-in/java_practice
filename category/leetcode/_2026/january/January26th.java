package category.leetcode._2026.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class January26th {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> answer = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int currDiff = arr[i] - arr[i - 1];

            if (currDiff < minDiff) {
                answer.clear();
                answer.add(List.of(arr[i - 1], arr[i]));
                minDiff = currDiff;
            } else if (currDiff == minDiff) {
                answer.add(List.of(arr[i - 1], arr[i]));
            }
        }

        return answer;
    }
}
