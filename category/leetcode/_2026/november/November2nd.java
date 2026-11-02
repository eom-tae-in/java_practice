package category.leetcode._2026.november;

import java.util.Arrays;

public class November2nd {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        long moves = 0;

        for (int num : nums) {
            moves += Math.abs((long) num - median);
        }

        return (int) moves;
    }
}
