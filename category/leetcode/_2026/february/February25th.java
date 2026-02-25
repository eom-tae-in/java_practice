package category.leetcode._2026.february;

import java.util.Arrays;
import java.util.Comparator;

public class February25th {

    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Number[] numbers = new Number[n];

        for (int i = 0; i < arr.length; i++) {
            numbers[i] = new Number(arr[i]);
        }

        Arrays.sort(
                numbers,
                Comparator.comparingInt((Number number) -> number.bitCount)
                        .thenComparingInt((Number number) -> number.num)
        );

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = numbers[i].num;
        }

        return answer;
    }

    private static class Number {

        private final int num;
        private final int bitCount;

        private Number(int num) {
            this.num = num;
            this.bitCount = Integer.bitCount(num);
        }
    }
}
