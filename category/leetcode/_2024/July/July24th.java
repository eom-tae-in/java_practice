package category.leetcode._2024.July;

import java.util.PriorityQueue;
import java.util.Queue;

public class July24th {

    public int[] sortJumbled(final int[] mapping, final int[] nums) {
        Queue<MappingNumber> queue = new PriorityQueue<>(
                (a, b) -> a.getNum() == b.getNum() ? a.getIndex() - b.getIndex() : a.getNum() - b.getNum());
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int mappingNumber = getMappingNumber(mapping, nums[i]);
            queue.offer(new MappingNumber(mappingNumber, i));
        }
        int[] answer = new int[n];
        int index = 0;
        while (!queue.isEmpty()) {
            MappingNumber current = queue.poll();
            answer[index++] = nums[current.getIndex()];
        }

        return answer;
    }

    private int getMappingNumber(final int[] mapping, final int nums) {
        int current = nums;
        int mappingNumber = 0;
        int count = 1;
        while (current >= 0) {
            int rest = current % 10;
            mappingNumber = count * mapping[rest] + mappingNumber;
            current /= 10;
            if (current == 0) {
                current = -1;
            }
            count *= 10;
        }

        return mappingNumber;
    }
}

class MappingNumber {
    private final int num;
    private final int index;

    MappingNumber(final int num, final int index) {
        this.num = num;
        this.index = index;
    }

    int getNum() {
        return num;
    }

    int getIndex() {
        return index;
    }
}
