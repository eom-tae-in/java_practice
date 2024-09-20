package category.leetcode._2024.july;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class July23rd {

    public int[] frequencySort(final int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Number> queue = new PriorityQueue<>(
                (a, b) -> a.getFrequency() == b.getFrequency() ? b.getNum() - a.getNum()
                        : a.getFrequency() - b.getFrequency());
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new Number(entry.getKey(), entry.getValue()));
        }
        int index = 0;
        while (!queue.isEmpty()) {
            Number current = queue.poll();
            int count = current.getFrequency();
            for (int i = 0; i < count; i++) {
                nums[index++] = current.getNum();
            }
        }

        return nums;
    }
}

class Number {

    private final int num;
    private final int frequency;

    Number(final int num, final int frequency) {
        this.num = num;
        this.frequency = frequency;
    }

    int getNum() {
        return num;
    }

    int getFrequency() {
        return frequency;
    }
}
