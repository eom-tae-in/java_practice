package category.leetcode._2025.november;

import java.util.Arrays;

public class November27th {

    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        long answer = Long.MIN_VALUE;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        minPrefix[0] = 0;

        for (int i = 1; i <= n; i++) {
            int mod = i % k;

            if (minPrefix[mod] != Long.MAX_VALUE) {
                answer = Math.max(answer, prefix[i] - minPrefix[mod]);
            }

            minPrefix[mod] = Math.min(minPrefix[mod], prefix[i]);
        }

        return answer;
    }
}
