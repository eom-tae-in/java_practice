package category.leetcode._2026.november;

import java.util.List;

public class November14th {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int answer = Integer.MAX_VALUE;

        for (int start = 0; start <= n - l; start++) {
            int sum = 0;

            for (int end = start; end < n && end < start + r; end++) {
                sum += nums.get(end);

                int length = end - start + 1;

                if (length >= l && sum > 0) {
                    answer = Math.min(answer, sum);
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
