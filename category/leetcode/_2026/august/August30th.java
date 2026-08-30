package category.leetcode._2026.august;

public class August30th {

    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 1; i < n; i++) {
            int curr = nums[i];

            if (curr < nums[minIdx]) {
                minIdx = i;
            }

            if (curr > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);
        int deleteFromLeft = right + 1;
        int deleteFromRight = n - left;
        int deleteFromBoth = (left + 1) + (n - right);

        return Math.min(deleteFromLeft, Math.min(deleteFromRight, deleteFromBoth));
    }
}
