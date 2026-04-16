package category.leetcode._2026.april;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class April16th {

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
        }

        List<Integer> answer = new ArrayList<>();

        for (int query : queries) {
            List<Integer> value = map.get(nums[query]);
            int n = value.size();

            if (value.size() == 1) {
                answer.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(value, query);
            int leftPos = (idx - 1 + n) % n;
            int rightPos = (idx + 1) % n;
            int leftIdx = value.get(leftPos);
            int rightIdx = value.get(rightPos);
            int leftDist = getDist(query, leftIdx, nums.length);
            int rightDist = getDist(query, rightIdx, nums.length);
            int min = Math.min(leftDist, rightDist);
            answer.add(min);
        }

        return answer;
    }

    private int getDist(int primary, int secondary, int n) {
        int diff = Math.abs(primary - secondary);

        return Math.min(diff, n - diff);
    }
}
