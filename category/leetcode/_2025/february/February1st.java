package category.leetcode._2025.february;

public class February1st {

    public boolean isArraySpecial(final int[] nums) {
        int prev = -1;

        for (int num : nums) {
            int current = num % 2;

            if (prev == current) {
                return false;
            }

            prev = current;
        }

        return true;
    }
}
