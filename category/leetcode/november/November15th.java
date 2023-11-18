package category.leetcode.november;

import java.util.Arrays;

public class November15th {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int max = 1;
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != max) {
                max += 1;
            }
        }

        return max;
    }
}
