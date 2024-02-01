package category.leetcode._2024.february;

import java.util.Arrays;

public class February1st {

    public int[][] divideArray(final int[] nums, final int k) {
        final int size = nums.length;
        int[][] answer = new int[size / 3][3];
        Arrays.sort(nums);

        for (int i = 2; i < size; i += 3) {
            if (nums[i] - nums[i - 2] > k) {
                return new int[0][];
            }
            answer[i / 3] = new int[]{nums[i - 2], nums[i - 1], nums[i]};
        }

        return answer;
    }
}
