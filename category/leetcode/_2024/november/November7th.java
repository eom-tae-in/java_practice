package category.leetcode._2024.november;

import java.util.Arrays;

public class November7th {

    public int largestCombination(final int[] candidates) {
        int[] digits = new int[32];

        for (int candidate : candidates) {
            int index = 0;
            while (index < 32) {
                if ((candidate >> index & 1) == 1) {
                    digits[index]++;
                }
                if (candidate >> index == 0) {
                    break;
                }
                index++;
            }
        }

        return Arrays.stream(digits)
                .max()
                .orElse(-1);
    }
}
