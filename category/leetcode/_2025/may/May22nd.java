package category.leetcode._2025.may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class May22nd {

    public int maxRemoval(final int[] nums, final int[][] queries) {
        int numsLength = nums.length;
        int[] prefixSum = new int[numsLength + 1];
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
        int queryIndex = 0;

        for (int i = 0; i < numsLength; i++) {
            prefixSum[i] += i == 0 ? 0 : prefixSum[i - 1];

            while (queryIndex < queries.length && queries[queryIndex][0] == i) {
                queue.offer(queries[queryIndex++][1]);
            }

            while (nums[i] > prefixSum[i]) {
                if (queue.isEmpty() || queue.peek() < i) {
                    return -1;
                }

                int endIndex = queue.poll();
                prefixSum[i]++;
                prefixSum[endIndex + 1]--;
            }
        }

        return queue.size();
    }
}
