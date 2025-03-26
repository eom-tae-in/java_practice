package category.leetcode._2025.march;

import java.util.Arrays;

public class March26th {

    public int minOperations(final int[][] grid, final int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];

        for (int i = 0; i < m; ++i) {
            System.arraycopy(grid[i], 0, arr, i * n, n);
        }

        if (Arrays.stream(arr).anyMatch(a -> (a - arr[0]) % x != 0)) {
            return -1;
        }

        int answer = 0;
        Arrays.sort(arr);

        for (int a : arr) {
            answer += Math.abs(a - arr[arr.length / 2]) / x;
        }

        return answer;
    }
}
