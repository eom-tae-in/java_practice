package category.leetcode._2025.january;

import java.util.Arrays;

public class January3rd {

    public int waysToSplitArray(final int[] nums) {
        int answer = 0;
        long prefix = 0;
        long suffix = Arrays.stream(nums)
                .asLongStream()
                .sum();

        for (int i = 0; i < nums.length - 1; i++) {
            prefix += nums[i];
            suffix -= nums[i];

            if (prefix >= suffix) {
                ++answer;
            }
        }

        return answer;
    }
}
