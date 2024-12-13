package category.leetcode._2024.december;

import java.util.PriorityQueue;
import java.util.Queue;

public class December13th {

    public long findScore(final int[] nums) {
        int numsLength = nums.length;
        long answer = 0;
        boolean[] isMarked = new boolean[numsLength];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ?
                Integer.compare(a[0], b[0]) :
                Integer.compare(a[1], b[1]));

        for (int i = 0; i < numsLength; i++) {
            queue.offer(new int[]{i, nums[i]});
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentIndex = poll[0];
            int currentValue = poll[1];

            if (!isMarked[currentIndex]) {
                if (currentIndex == 0 && currentIndex + 1 < numsLength) {
                    isMarked[currentIndex + 1] = true;
                } else if (currentIndex == numsLength - 1 && currentIndex > 0) {
                    isMarked[currentIndex - 1] = true;
                } else {
                    if (numsLength > 2) {
                        isMarked[currentIndex + 1] = true;
                        isMarked[currentIndex - 1] = true;
                    }
                }
                isMarked[currentIndex] = true;
                answer += currentValue;
            }
        }

        return answer;
    }
}
