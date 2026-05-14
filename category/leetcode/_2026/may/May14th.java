package category.leetcode._2026.may;

public class May14th {

    public boolean isGood(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];

        for (int num : nums) {
            if (num > n - 1) {
                return false;
            }

            count[num]++;

            if (num == n - 1) {
                if (count[num] > 2) {
                    return false;
                }
            } else {
                if (count[num] > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
