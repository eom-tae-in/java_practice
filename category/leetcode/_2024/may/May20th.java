package category.leetcode._2024.may;

public class May20th {

    public int subsetXORSum(final int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(final int[] nums, final int index, final int xorValue) {
        if (index == nums.length) {
            return xorValue;
        }

        final int excludeCurrent = dfs(nums, index + 1, xorValue);
        final int includeCurrent = dfs(nums, index + 1, nums[index] ^ xorValue);

        return excludeCurrent + includeCurrent;
    }
}
