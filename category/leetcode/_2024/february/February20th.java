package category.leetcode._2024.february;

import java.util.Arrays;
import java.util.stream.IntStream;

public class February20th {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int rangeSum = IntStream.rangeClosed(1, length)
                .sum();
        int arraySum = Arrays.stream(nums)
                .sum();
        return rangeSum - arraySum;
    }
}
