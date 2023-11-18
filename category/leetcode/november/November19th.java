package category.leetcode.november;

import java.util.Arrays;

public class November19th {

    public int maxFrequency(int[] nums, int k) {
        long sum = 0;
        int ans = 0;
        Arrays.sort(nums);

        for (int i = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum + k < (long) nums[r] * (r - i + 1)) {
                sum -= nums[i++];
            }
            ans = Math.max(ans, r - i + 1);
        }

        return ans;
    }
}
