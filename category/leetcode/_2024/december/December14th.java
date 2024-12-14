package category.leetcode._2024.december;

public class December14th {

    public long continuousSubarrays(final int[] nums) {
        long answer = 1;
        int min = nums[0] - 2;
        int max = nums[0] + 2;
        int numsLength = nums.length;

        for (int left = 0, right = 1; right < numsLength; right++) {
            int current = nums[right];

            if (min <= current && current <= max) {
                min = Math.max(min, current - 2);
                max = Math.min(max, current + 2);
            } else {
                left = right;
                min = current - 2;
                max = current + 2;

                while (min <= nums[left] && nums[left] <= max) {
                    min = Math.max(min, nums[left] - 2);
                    max = Math.min(max, nums[left] + 2);
                    left--;
                }

                left++;
            }

            answer += right - left + 1;
        }

        return answer;
    }
}
