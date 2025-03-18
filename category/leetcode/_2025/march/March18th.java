package category.leetcode._2025.march;

public class March18th {

    public int longestNiceSubarray(final int[] nums) {
        int answer = 1;
        int numsLength = nums.length;
        int sum = 0;

        for (int left = 0, right = 0; right < numsLength; right++) {
            while ((sum & nums[right]) > 0) {
                sum ^= nums[left++];
            }

            sum |= nums[right];
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
