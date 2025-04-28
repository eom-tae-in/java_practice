package category.leetcode._2025.april;

public class April28th {

    public long countSubarrays(final int[] nums, final long k) {
        long answer = 0;
        long sum = 0;

        for (int l = 0, r = 0; r < nums.length; ++r) {
            sum += nums[r];

            while (sum * (r - l + 1) >= k) {
                sum -= nums[l++];
            }

            answer += r - l + 1;
        }

        return answer;
    }
}
