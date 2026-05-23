package category.leetcode._2026.may;

public class May23rd {

    public boolean check(int[] nums) {
        boolean foundRotation = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                if (foundRotation) {
                    return false;
                } else {
                    foundRotation = true;
                }
            }
        }

        return true;
    }
}
