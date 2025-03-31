package category.leetcode._2025.march;

import java.util.Arrays;

public class March31st {

    public long putMarbles(final int[] weights, final int k) {
        int[] arr = new int[weights.length - 1];
        long mn = 0;
        long mx = 0;

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(arr);

        for (int i = 0; i < k - 1; ++i) {
            mn += arr[i];
            mx += arr[arr.length - 1 - i];
        }

        return mx - mn;
    }
}
