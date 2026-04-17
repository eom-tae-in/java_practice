package category.leetcode._2026.april;

import java.util.HashMap;
import java.util.Map;

public class April17th {

    private static final int INIT = Integer.MAX_VALUE / 2;

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int answer = INIT;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int curr = nums[i];

            if (map.containsKey(curr)) {
                answer = Math.min(answer, i - map.get(curr));
            }

            map.put(getReverse(curr), i);
        }

        return answer == INIT ? -1 : answer;
    }

    private int getReverse(int num) {
        int reverse = 0;

        while (num > 0) {
            reverse *= 10;
            reverse += num % 10;
            num /= 10;
        }

        return reverse;
    }
}
