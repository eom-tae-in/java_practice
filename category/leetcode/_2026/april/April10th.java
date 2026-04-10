package category.leetcode._2026.april;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class April10th {

    private static final int INIT = Integer.MAX_VALUE / 2;

    public int minimumDistance(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int answer = INIT;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.containsKey(num)) {
                int[] value = map.get(num);
                int count = applyNum(value, i);

                if (count == 3) {
                    answer = Math.min(answer, calculateDist(value));
                }
            } else {
                int[] value = new int[3];
                Arrays.fill(value, -1);
                value[0] = i;
                map.put(num, value);
            }
        }

        return answer == INIT ? -1 : answer;
    }

    private int calculateDist(int[] value) {
        return value[2] - value[0] + value[2] - value[1] + value[1] - value[0];
    }

    private int applyNum(int[] value, int num) {
        if (value[0] == -1) {
            value[0] = num;

            return 1;
        } else if (value[1] == -1) {
            value[1] = num;

            return 2;
        } else if (value[2] == -1) {
            value[2] = num;

            return 3;
        } else {
            value[0] = value[1];
            value[1] = value[2];
            value[2] = num;

            return 3;
        }
    }
}
