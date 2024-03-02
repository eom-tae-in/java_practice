package category.leetcode._2024.March;

import java.util.Arrays;

public class March2nd {

    public int[] sortedSquares(int[] nums) {
        int[] squareNums = Arrays.stream(nums)
                .map(num -> num * num)
                .toArray();

        Arrays.sort(squareNums);
        return squareNums;
    }
}
