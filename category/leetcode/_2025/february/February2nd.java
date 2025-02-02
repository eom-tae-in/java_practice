package category.leetcode._2025.february;

public class February2nd {

    public boolean check(final int[] nums) {
        int n = nums.length;
        int rotates = 0;

        for (int i = 0; i < n; ++i) {
            if (nums[i] > nums[(i + 1) % n] && ++rotates > 1) {
                return false;
            }
        }

        return true;
    }
}
