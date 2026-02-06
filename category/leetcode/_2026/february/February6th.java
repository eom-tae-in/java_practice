package category.leetcode._2026.february;

import java.util.Arrays;

public class February6th {

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int maxLen = 1;

        for (int right = 0; right < n; right++) {
            while (nums[right] > (long) k * nums[left]) {
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return n - maxLen;
    }
}
