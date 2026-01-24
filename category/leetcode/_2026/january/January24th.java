package category.leetcode._2026.january;

import java.util.Arrays;

public class January24th {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int answer = 0;

        while (left < right) {
            int curr = nums[left] + nums[right];

            if (curr > answer) {
                answer = curr;
            }

            left++;
            right--;
        }

        return answer;
    }
}
