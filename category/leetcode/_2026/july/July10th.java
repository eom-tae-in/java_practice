package category.leetcode._2026.july;

import java.util.Arrays;
import java.util.Comparator;

public class July10th {

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int[] sorted = new int[n];
        int[] indexMap = new int[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = arr[i][0];
            indexMap[arr[i][1]] = i;
        }

        int log = 32 - Integer.numberOfLeadingZeros(n);
        int[][] jump = new int[n][log + 1];
        int right = 0;

        for (int left = 0; left < n; left++) {
            while (right + 1 < n && sorted[right + 1] - sorted[left] <= maxDiff) {
                right++;
            }

            jump[left][0] = right;
        }

        for (int k = 1; k <= log; k++) {
            for (int i = 0; i < n; i++) {
                jump[i][k] = jump[jump[i][k - 1]][k - 1];
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int a = indexMap[queries[i][0]];
            int b = indexMap[queries[i][1]];
            int start = Math.min(a, b);
            int end = Math.max(a, b);
            answer[i] = minJump(jump, start, end, log);
        }

        return answer;
    }

    private int minJump(int[][] jump, int start, int end, int LOG) {
        if (start == end) {
            return 0;
        }

        if (jump[start][0] >= end) {
            return 1;
        }

        if (jump[start][LOG] < end) {
            return -1;
        }

        int answer = 0;
        int cur = start;

        for (int k = LOG; k >= 0; k--) {
            if (jump[cur][k] < end) {
                answer += 1 << k;
                cur = jump[cur][k];
            }
        }

        return answer + 1;
    }
}
