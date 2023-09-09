package category.leetcode.august;

import java.util.ArrayDeque;
import java.util.Deque;

public class August16th {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; ++i) {
            while (!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(nums[i]);
            if (i >= k && nums[i - k] == dq.peekFirst()) {
                dq.pollFirst();
            }
            if (i >= k - 1) {
                ans[i - k + 1] = dq.peekFirst();
            }
        }
        return ans;
    }
}
