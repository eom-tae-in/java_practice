package category.leetcode._2026.september;

public class September23rd {

    public int minOperations(int[] nums, int x) {
        long total = 0;

        for (int num : nums) {
            total += num;
        }

        long target = total - x;

        if (target < 0) {
            return -1;
        }

        int left = 0;
        int maxLength = -1;
        long sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (left <= right && sum > target) {
                sum -= nums[left++];
            }

            if (sum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}
