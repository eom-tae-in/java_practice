package category.leetcode._2024.june;

public class June24th {

    public int minKBitFlips(final int[] nums, final int k) {
        int flippedCount = 0;
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i >= k && nums[i - k] == 2) {
                flippedCount--;
            }
            if (flippedCount % 2 == nums[i]) {
                if (i + k > n) {
                    return -1;
                }
                flippedCount++;
                count++;
                nums[i] = 2;
            }
        }

        return count;
    }
}
