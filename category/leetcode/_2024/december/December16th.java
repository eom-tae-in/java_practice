package category.leetcode._2024.december;

import java.util.PriorityQueue;
import java.util.Queue;

public class December16th {

    public int[] getFinalState(final int[] nums, final int k, final int multiplier) {
        Queue<Integer> queue = new PriorityQueue<>();
        int numsLength = nums.length;

        for (int num : nums) {
            queue.offer(num);
        }

        for (int i = 0; i < k; i++) {
            int min = queue.poll();

            for (int j = 0; j < numsLength; j++) {
                if (nums[j] == min) {
                    nums[j] *= multiplier;
                    queue.offer(nums[j]);
                    break;
                }
            }
        }

        return nums;
    }
}
