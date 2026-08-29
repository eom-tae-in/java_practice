package category.leetcode._2026.august;

import java.util.Arrays;
import java.util.Comparator;

public class August29th {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] elements = new int[n][2];

        for (int i = 0; i < n; i++) {
            elements[i][0] = nums[i];
            elements[i][1] = i;
        }

        Arrays.sort(elements, Comparator.comparingInt(element -> element[0]));
        int[] answer = new int[n];
        int groupStart = 0;

        while (groupStart < n) {
            int groupEnd = groupStart + 1;

            while (groupEnd < n && elements[groupEnd][0] - elements[groupEnd - 1][0] <= limit) {
                groupEnd++;
            }

            int size = groupEnd - groupStart;
            int[] indices = new int[size];

            for (int i = 0; i < size; i++) {
                indices[i] = elements[groupStart + i][1];
            }

            Arrays.sort(indices);

            for (int i = 0; i < size; i++) {
                answer[indices[i]] = elements[groupStart + i][0];
            }

            groupStart = groupEnd;
        }

        return answer;
    }
}
