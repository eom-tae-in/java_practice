package category.leetcode._2025.march;

public class March15th {

    public int minCapability(final int[] nums, final int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int left = min;
        int right = max;

        while (left < right) {
            int mid = (left + right) / 2;
            int stolenHouses = 0;

            for (int i = 0; i < nums.length; i++) {
                int current = nums[i];

                if (current <= mid) {
                    stolenHouses++;
                    i++;
                }
            }

            if (stolenHouses >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
