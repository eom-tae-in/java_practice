package category.leetcode._2025.april;

public class April17th {

    public int countPairs(final int[] nums, final int k) {
        int answer = 0;

        for (int left = 0; left < nums.length - 1; left++) {
            for (int right = left + 1; right < nums.length; right++) {
                if (nums[left] == nums[right] && (left * right) % k == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
