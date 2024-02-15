package category.leetcode._2024.february;

import java.util.Arrays;

public class February15th {

    public long largestPerimeter(final int[] nums) {
        long totalSum = 0;
        Arrays.sort(nums);

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = nums.length - 1; i >= 2; i--) {
            totalSum -= nums[i];
            if (totalSum > nums[i]) {
                return totalSum + nums[i];
            }
        }
        return -1;
    }
}
