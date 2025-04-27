package category.leetcode._2025.april;

public class April27th {

    public int countSubarrays(final int[] nums) {
        int answer = 0;
        int numsLength = nums.length;

        for (int left = 0, right = 2; right < numsLength; left++, right++) {
            if (nums[left + 1] == (nums[left] + nums[right]) * 2) {
                answer++;
            }
        }

        return answer;
    }
}
