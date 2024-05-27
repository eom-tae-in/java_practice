package category.leetcode._2024.May;

public class May27th {

    public int specialArray(final int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            int count = 0;
            for (int num : nums) {
                if (num >= i) {
                    count++;
                }
            }
            if (i == count) {
                return i;
            }
        }

        return -1;
    }
}
