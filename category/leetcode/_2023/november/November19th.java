package category.leetcode._2023.november;

import java.util.Arrays;

public class November19th {

    public int reductionOperations(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                ans += nums.length - i;
            }
        }

        return ans;
    }
}
