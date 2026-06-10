package category.leetcode._2026.june;

import java.util.Comparator;
import java.util.PriorityQueue;

public class June10th {

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SparseTable st = new SparseTable(nums);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong((Node node) -> node.value).reversed());

        for (int l = 0; l < n; l++) {
            long value = st.rangeValue(l, n - 1);
            pq.offer(new Node(value, l, n - 1));
        }

        long answer = 0;

        for (int i = 0; i < k; i++) {
            Node curr = pq.poll();
            answer += curr.value;
            int l = curr.l;
            int r = curr.r;

            if (r - 1 >= l) {
                long nextValue = st.rangeValue(l, r - 1);
                pq.offer(new Node(nextValue, l, r - 1));
            }
        }

        return answer;
    }

    private static class Node {

        private final long value;
        private final int l;
        private final int r;

        private Node(long value, int l, int r) {
            this.value = value;
            this.l = l;
            this.r = r;
        }
    }

    private static class SparseTable {

        private final int[][] maxTable;
        private final int[][] minTable;
        private final int[] log;

        private SparseTable(int[] nums) {
            int n = nums.length;
            log = new int[n + 1];

            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }

            int K = log[n] + 1;
            maxTable = new int[K][n];
            minTable = new int[K][n];

            for (int i = 0; i < n; i++) {
                maxTable[0][i] = nums[i];
                minTable[0][i] = nums[i];
            }

            for (int k = 1; k < K; k++) {
                int len = 1 << k;
                int half = len >> 1;

                for (int i = 0; i + len <= n; i++) {
                    maxTable[k][i] = Math.max(maxTable[k - 1][i], maxTable[k - 1][i + half]);
                    minTable[k][i] = Math.min(minTable[k - 1][i], minTable[k - 1][i + half]);
                }
            }
        }

        private long rangeValue(int l, int r) {
            int len = r - l + 1;
            int k = log[len];
            int interval = 1 << k;
            int max = Math.max(maxTable[k][l], maxTable[k][r - interval + 1]);
            int min = Math.min(minTable[k][l], minTable[k][r - interval + 1]);

            return (long) max - min;
        }
    }
}
