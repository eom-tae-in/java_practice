package category.leetcode._2026.june;

public class June26th {

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int offset = n + 1;
        Fenwick fenwick = new Fenwick(2 * n + 3);
        long answer = 0;
        int prefix = 0;
        fenwick.add(prefix + offset, 1);

        for (int num : nums) {
            prefix += (num == target) ? 1 : -1;
            answer += fenwick.sum(prefix + offset - 1);
            fenwick.add(prefix + offset, 1);
        }

        return answer;
    }

    private static class Fenwick {

        private final long[] tree;

        private Fenwick(int size) {
            tree = new long[size + 1];
        }

        private void add(int index, long value) {
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        private long sum(int index) {
            long result = 0;

            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }

            return result;
        }
    }
}
