package category.leetcode._2024.august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class August4th {
    public int rangeSum(final int[] nums, final int n, final int left, final int right) {
        List<Integer> list = new ArrayList<>();
        int mod = 1_000_000_007;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            list.add(sum);
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        for (int i = left - 1; i < right; i++) {
            answer = (answer + list.get(i)) % mod;
        }

        return answer;
    }
}
