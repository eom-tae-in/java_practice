package category.leetcode._2026.may;

public class May7th {

    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int[] max = new int[n];
        max[0] = nums[0];

        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(min, nums[i + 1]);

            if (min < max[i]) {
                max[i] = max[i + 1];
            }
        }

        return max;
    }
}
