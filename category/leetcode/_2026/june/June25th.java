package category.leetcode._2026.june;

public class June25th {

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int answer = 0;

        for (int left = 0; left < n; left++) {
            int targetCount = 0;

            for (int right = left; right < n; right++) {
                if (nums[right] == target) {
                    targetCount++;
                }

                int length = right - left + 1;

                if (targetCount * 2 > length) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
