package category.leetcode._2024.June;

public class June22nd {
    public int numberOfSubarrays(final int[] nums, final int k) {
        return calculateNiceSubarrays(nums, k) - calculateNiceSubarrays(nums, k - 1);
    }

    private int calculateNiceSubarrays(final int[] nums, int k) {
        int count = 0;
        for (int left = 0, right = 0; right <= nums.length; ) {
            if (k >= 0) {
                count += right - left;
                if (right == nums.length) {
                    break;
                }
                if (nums[right] % 2 == 1) {
                    --k;
                }
                ++right;
            } else {
                if (nums[left] % 2 == 1) {
                    ++k;
                }
                ++left;
            }
        }

        return count;

    }
}
