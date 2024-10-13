package category.leetcode._2024.october;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class October13th {

    public int[] smallestRange(final List<List<Integer>> nums) {
        Queue<T> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.num));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); ++i) {
            int num = nums.get(i).get(0);
            minHeap.offer(new T(i, 0, num));
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int minRange = min;
        int maxRange = max;

        while (!minHeap.isEmpty() && minHeap.size() == nums.size()) {
            int i = minHeap.peek().i;
            int j = minHeap.poll().j;
            if (j + 1 < nums.get(i).size()) {
                minHeap.offer(new T(i, j + 1, nums.get(i).get(j + 1)));
                max = Math.max(max, nums.get(i).get(j + 1));
                min = minHeap.peek().num;
            }
            if (max - min < maxRange - minRange) {
                minRange = min;
                maxRange = max;
            }
        }

        return new int[]{minRange, maxRange};
    }

    record T(
            int i,
            int j,
            int num
    ) {
    }
}
