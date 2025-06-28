package category.leetcode._2025.june;

import java.util.Arrays;

public class June28th {

    public int[] maxSubsequence(int[] nums, int k) {
        int[] answer = new int[k];
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int numsLength = nums.length;
        int threshold = copy[numsLength - k];
        int notThresholdCount = 0;

        for (int i = numsLength - 1; i >= 0; i--) {
            if (nums[i] > threshold) {
                notThresholdCount++;
            }
        }

        int equal = k - notThresholdCount;
        int index = 0;

        for (int num : nums) {
            if (num > threshold) {
                answer[index++] = num;
            } else if (num == threshold && equal > 0) {
                answer[index++] = num;
                equal--;
            }
        }

        return answer;
    }
}
