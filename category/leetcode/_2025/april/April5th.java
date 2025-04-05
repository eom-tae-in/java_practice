package category.leetcode._2025.april;

public class April5th {

    public int subsetXORSum(final int[] nums) {
        return backtrack(0, 0, nums);
    }

    private int backtrack(final int index, final int xors, final int[] nums) {
        if (nums.length == index) {
            return xors;
        }

        return backtrack(index + 1, xors, nums) + backtrack(index + 1, xors ^ nums[index], nums);
    }
}
