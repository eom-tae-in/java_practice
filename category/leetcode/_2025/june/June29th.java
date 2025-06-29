package category.leetcode._2025.june;

import java.util.Arrays;

public class June29th {

    public int numSubseq(int[] nums, int target) {
        int answer = 0;
        int mod = 1_000_000_007;
        int numsLength = nums.length;
        int[] pow = new int[numsLength];
        pow[0] = 1;

        for (int i = 1; i < numsLength; i++) {
            pow[i] = pow[i - 1] * 2 % mod;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = numsLength - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                answer += pow[right - left];
                answer %= mod;
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }
}
