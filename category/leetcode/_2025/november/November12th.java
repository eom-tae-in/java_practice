package category.leetcode._2025.november;

public class November12th {

    public int minOperations(int[] nums) {
        int ones = 0;
        int n = nums.length;

        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
        }

        if (ones > 0) {
            return n - ones;
        }

        int minOps = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int g = nums[i];

            for (int j = i + 1; j < n; j++) {
                g = getGcd(g, nums[j]);

                if (g == 1) {
                    minOps = Math.min(minOps, j - i);
                    break;
                }
            }
        }

        return minOps == Integer.MAX_VALUE ? -1 : minOps + n - 1;
    }

    private int getGcd(int primary, int secondary) {
        if (primary < secondary) {
            int temp = primary;
            primary = secondary;
            secondary = temp;
        }

        while (secondary != 0) {
            int temp = primary % secondary;
            primary = secondary;
            secondary = temp;
        }

        return primary;
    }
}
