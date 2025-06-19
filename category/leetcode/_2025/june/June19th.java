package category.leetcode._2025.june;

import java.util.Arrays;

public class June19th {

    public int partitionArray(int[] nums, int k) {
        int count = 1;
        int numsLength = nums.length;
        Arrays.sort(nums);
        int start = nums[0];

        for (int i = 1; i < numsLength; i++) {
            if (nums[i] - start > k) {
                count++;
                start = nums[i];
            }
        }

        return count;
    }
}
