package category.leetcode._2024.June;

import java.util.Arrays;

public class June14th {

    public int minIncrementForUnique(final int[] nums) {
        int answer = 0;
        int minValue = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            answer += Math.max(minValue - num, 0);
            minValue = Math.max(minValue, num) + 1;
        }

        return answer;
    }
}
