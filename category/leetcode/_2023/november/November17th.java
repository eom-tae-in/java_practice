package category.leetcode._2023.november;

import java.util.Arrays;

public class November17th {

    public int minPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);

        for (int l = 0, r = nums.length - 1; l < r; ) {
            ans = Math.max(ans, nums[l++] + nums[r--]);
        }

        return ans;
    }
}
