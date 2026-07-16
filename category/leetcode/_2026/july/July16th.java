package category.leetcode._2026.july;

import java.util.Arrays;

public class July16th {

    public long gcdSum(int[] nums) {
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            nums[i] = gcd(nums[i], max);
        }

        Arrays.sort(nums);
        long answer = 0;
        int half = n / 2;

        for (int i = 0; i < half; i++) {
            answer += gcd(nums[i], nums[n - 1 - i]);
        }

        return answer;
    }

    private int gcd(int primary, int secondary) {
        while (secondary != 0) {
            int temp = primary % secondary;
            primary = secondary;
            secondary = temp;
        }

        return primary;
    }
}
