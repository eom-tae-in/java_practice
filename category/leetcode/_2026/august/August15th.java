package category.leetcode._2026.august;

public class August15th {

    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            totalXor ^= num;

            if (num != 0) {
                hasNonZero = true;
            }
        }

        if (totalXor != 0) {
            return nums.length;
        }

        if (hasNonZero) {
            return nums.length - 1;
        }

        return 0;
    }
}
