package category.leetcode._2025.october;

import java.util.Arrays;

public class October18th {

    public int maxDistinctElements(int[] nums, int k) {
        int answer = 0;
        int occupied = Integer.MIN_VALUE;
        Arrays.sort(nums);

        for (int num : nums) {
            if (occupied < num + k) {
                occupied = Math.max(occupied + 1, num - k);
                answer++;
            }
        }

        return answer;
    }
}
