package category.leetcode._2026.november;

import java.util.Arrays;

public class November25th {

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int size = n + 1;
        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] count = new int[Math.max(size, max + 1)];
        int[] order = new int[size];
        int[] rank = new int[size];
        int[] next = new int[size];
        int[] starts = new int[size];
        count[0] = 1;

        for (int x : nums) {
            count[x]++;
        }

        for (int i = 1; i <= max; i++) {
            if (count[i] == 1) return 1;
            count[i] += count[i - 1];
        }

        order[0] = n;

        for (int i = 0; i < n; i++) {
            order[--count[nums[i]]] = i;
        }

        int classes = 1;

        for (int i = 1; i < size; i++) {
            if (i == 1 || nums[order[i]] != nums[order[i - 1]]) classes++;
            rank[order[i]] = classes - 1;
        }

        for (int width = 1; classes < size; width *= 2) {
            Arrays.fill(count, 0, classes, 0);

            for (int i = 0; i < size; i++) {
                int start = order[i] - width;

                if (start < 0) {
                    start += size;
                }

                starts[i] = start;
                count[rank[start]]++;
            }

            for (int i = 1; i < classes; i++) {
                count[i] += count[i - 1];
            }

            for (int i = size - 1; i >= 0; i--) {
                int start = starts[i];
                order[--count[rank[start]]] = start;
            }

            classes = 1;
            next[order[0]] = 0;

            for (int i = 1; i < size; i++) {
                int a = order[i - 1], b = order[i];

                if (rank[a] != rank[b] || rank[(a + width) % size] != rank[(b + width) % size]) {
                    classes++;
                }

                next[b] = classes - 1;
            }

            int[] temp = rank;
            rank = next;
            next = temp;
        }

        int[] lcp = new int[size + 1];
        int common = 0;

        for (int i = 0; i < n; i++) {
            int pos = rank[i];
            int j = order[pos - 1];

            while (i + common < n && j + common < n && nums[i + common] == nums[j + common]) {
                common++;
            }

            lcp[pos] = common;

            if (common > 0) {
                common--;
            }
        }

        int answer = n;

        for (int pos = 1; pos < size; pos++) {
            int length = Math.max(lcp[pos], lcp[pos + 1]) + 1;

            if (length <= n - order[pos]) {
                answer = Math.min(answer, length);
            }
        }

        return answer;
    }
}
