package category.leetcode._2025.august;

public class August6th {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree segmentTree = new SegmentTree(baskets);
        int answer = 0;

        for (int fruit : fruits) {
            if (segmentTree.queryFirst(fruit) == -1) {
                answer++;
            }
        }

        return answer;
    }

    private static class SegmentTree {

        private final int n;
        private final int[] tree;

        private SegmentTree(int[] nums) {
            this.n = nums.length;
            this.tree = new int[n * 4];
            build(nums, 0, 0, n - 1);
        }

        private void build(int[] nums, int treeIndex, int low, int high) {
            if (low == high) {
                tree[treeIndex] = nums[low];
                return;
            }

            int mid = low + (high - low) / 2;
            build(nums, 2 * treeIndex + 1, low, mid);
            build(nums, 2 * treeIndex + 2, mid + 1, high);
            tree[treeIndex] = Math.max(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
        }

        public void update(int i, int val) {
            update(0, 0, n - 1, i, val);
        }

        private void update(int treeIndex, int low, int high, int i, int value) {
            if (low == high) {
                tree[treeIndex] = value;
                return;
            }

            int mid = low + (high - low) / 2;

            if (i <= mid) {
                update(2 * treeIndex + 1, low, mid, i, value);
            } else {
                update(2 * treeIndex + 2, mid + 1, high, i, value);
            }

            tree[treeIndex] = Math.max(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
        }

        public int queryFirst(int target) {
            return queryFirst(0, 0, n - 1, target);
        }

        private int queryFirst(int treeIndex, int low, int high, int target) {
            if (tree[treeIndex] < target) {
                return -1;
            }

            if (low == high) {
                update(low, -1);
                return low;
            }

            int mid = low + (high - low) / 2;

            if (tree[2 * treeIndex + 1] >= target) {
                return queryFirst(2 * treeIndex + 1, low, mid, target);
            } else {
                return queryFirst(2 * treeIndex + 2, mid + 1, high, target);
            }
        }
    }
}
