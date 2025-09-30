package category.leetcode._2025.september;

public class September30th {

    public int triangularSum(int[] nums) {
        for (int sz = nums.length; sz > 0; sz--) {
            for (int i = 0; i + 1 < sz; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }

        return nums[0];
    }
}
