package category.leetcode._2024.october;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class October30th {

    public int minimumMountainRemovals(final int[] nums) {
        int n = nums.length;
        int[] lengthOfLeftLIS = getLengthOfLIS(nums);
        int[] lengthOfRightLIS = reverse(getLengthOfLIS(reverse(nums)));
        int maxLength = 0;

        for (int i = 1; i < n - 1; i++) {
            if (lengthOfLeftLIS[i] > 1 && lengthOfRightLIS[i] > 1) {
                maxLength = Math.max(maxLength, lengthOfLeftLIS[i] + lengthOfRightLIS[i] - 1);
            }
        }

        return n - maxLength;
    }

    private int[] getLengthOfLIS(final int[] nums) {
        int n = nums.length;
        List<Integer> lis = new ArrayList<>();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int current = nums[i];
            if (lis.isEmpty() || current > lis.get(lis.size() - 1)) {
                lis.add(current);
            } else {
                lis.set(findEqualsOrFirstGreaterIndex(lis, current), current);
            }
            dp[i] = lis.size();
        }

        return dp;
    }

    private int findEqualsOrFirstGreaterIndex(final List<Integer> lis, final int current) {
        int index = Collections.binarySearch(lis, current);
        return index < 0 ? -(index + 1) : index;
    }

    private int[] reverse(final int[] nums) {
        int n = nums.length;
        int[] copyNums = new int[n];
        System.arraycopy(nums, 0, copyNums, 0, n);
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int temp = copyNums[left];
            copyNums[left] = copyNums[right];
            copyNums[right] = temp;
            left++;
            right--;
        }

        return copyNums;
    }
}
