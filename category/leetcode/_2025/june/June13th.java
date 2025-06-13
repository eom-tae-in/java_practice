package category.leetcode._2025.june;

import java.util.Arrays;

public class June13th {

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int numsLength = nums.length;
        int left = 0;
        int right = nums[numsLength - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;

            if (calculatePairs(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int calculatePairs(int[] nums, int maxDiff) {
        int pairs = 0;
        int numsLength = nums.length;

        for (int i = 1; i < numsLength; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                pairs++;
                i++;
            }
        }

        return pairs;
    }
}

