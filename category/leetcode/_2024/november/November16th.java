package category.leetcode._2024.november;

public class November16th {

    public int[] resultsArray(final int[] nums, final int k) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            answer[i] = isPower(i, i + k - 1, nums) ? nums[i + k - 1] : -1;
        }

        return answer;
    }

    private boolean isPower(final int start, final int end, final int[] nums) {
        for (int i = start; i < end; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
