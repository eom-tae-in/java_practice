package category.leetcode.september;

import java.util.ArrayDeque;
import java.util.Deque;

public class September30th {

    public boolean find132pattern(int[] nums) {
        //numI < numK < numJ (i < j < k)
        Deque<Integer> deque = new ArrayDeque<>();
        int numK = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < numK) {
                return true;
            }
            while (!deque.isEmpty() && deque.peek() < nums[i]) {
                numK = deque.pop();
            }
            deque.push(nums[i]);
        }
        return false;
    }
}
