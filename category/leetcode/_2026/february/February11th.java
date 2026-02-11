package category.leetcode._2026.february;

import java.util.Arrays;

public class February11th {

    private static final int INF = 1_000_000_000;
    private static final int MAX_VALUE = 100_000;

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        SegmentTree seg = new SegmentTree(n);
        int[] last = new int[MAX_VALUE + 1];
        int answer = 0;
        Arrays.fill(last, -1);

        for (int r = 0; r < n; r++) {
            int x = nums[r];
            int delta = (x & 1) == 0 ? 1 : -1;
            seg.update(1, 0, n - 1, r, r, -INF);
            seg.update(1, 0, n - 1, last[x] + 1, r, delta);
            last[x] = r;
            int idx = seg.findFirst(1, 0, n - 1);

            if (idx != -1) {
                answer = Math.max(answer, r - idx + 1);
            }
        }

        return answer;
    }

    private static class SegmentTree {

        private final int[] min;
        private final int[] max;
        private final int[] lazy;

        private SegmentTree(int n) {
            min = new int[4 * n];
            max = new int[4 * n];
            lazy = new int[4 * n];
            Arrays.fill(min, INF);
            Arrays.fill(max, INF);
        }

        private void push(int node) {
            int lz = lazy[node];

            if (lz != 0) {
                int l = node << 1;
                int r = l | 1;
                min[l] += lz;
                max[l] += lz;
                lazy[l] += lz;
                min[r] += lz;
                max[r] += lz;
                lazy[r] += lz;
                lazy[node] = 0;
            }
        }

        private void pull(int node) {
            int l = node << 1, r = l | 1;
            min[node] = Math.min(min[l], min[r]);
            max[node] = Math.max(max[l], max[r]);
        }

        private void update(
                int node,
                int segmentStart,
                int segmentEnd,
                int updateLeft,
                int updateRight,
                int deltaValue
        ) {
            if (updateLeft <= segmentStart && segmentEnd <= updateRight) {
                min[node] += deltaValue;
                max[node] += deltaValue;
                lazy[node] += deltaValue;
                return;
            }

            push(node);
            int mid = (segmentStart + segmentEnd) / 2;

            if (updateLeft <= mid) {
                update(node << 1, segmentStart, mid, updateLeft, updateRight, deltaValue);
            }

            if (updateRight > mid) {
                update(node << 1 | 1, mid + 1, segmentEnd, updateLeft, updateRight, deltaValue);
            }

            pull(node);
        }

        private int findFirst(
                int nodeIndex,
                int segmentStart,
                int segmentEnd
        ) {
            if (min[nodeIndex] > 0 || max[nodeIndex] < 0) {
                return -1;
            }

            if (segmentStart == segmentEnd) {
                return segmentStart;
            }

            push(nodeIndex);
            int mid = (segmentStart + segmentEnd) >>> 1;
            int res = findFirst(nodeIndex << 1, segmentStart, mid);

            if (res != -1) {
                return res;
            }

            return findFirst(nodeIndex << 1 | 1, mid + 1, segmentEnd);
        }
    }
}
