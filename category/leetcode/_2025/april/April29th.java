package category.leetcode._2025.april;

import java.util.Arrays;

public class April29th {

    public long countSubarrays(final int[] nums, final int k) {
        long answer = 0;
        int count = 0;
        int maxNum = Arrays.stream(nums)
                .max()
                .getAsInt();

        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == maxNum) {
                count++;
            }

            while (count == k) {
                if (nums[l++] == maxNum) {
                    count--;
                }
            }

            answer += l;
        }

        return answer;
    }
}
