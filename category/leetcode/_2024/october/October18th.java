package category.leetcode._2024.october;

import java.util.Arrays;

public class October18th {

    private int answer = 0;

    public int countMaxOrSubsets(final int[] nums) {
        final int orSum = Arrays.stream(nums)
                .reduce((a, b) -> a | b)
                .orElse(-1);

        dfs(nums, 0, 0, orSum);
        return answer;
    }


    private void dfs(final int[] nums, final int i, final int path, final int ors) {
        if (i == nums.length) {
            if (path == ors) {
                ++answer;
            }
            return;
        }

        dfs(nums, i + 1, path, ors);
        dfs(nums, i + 1, path | nums[i], ors);
    }
}
