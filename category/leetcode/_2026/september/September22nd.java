package category.leetcode._2026.september;

public class September22nd {

    private static class Node {
        int product;
        int[] count;

        Node(int k) {
            count = new int[k];
        }
    }

    private int k;
    private Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.tree = new Node[nums.length * 4];

        build(1, 0, nums.length - 1, nums);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // nums[index]를 value로 변경
            update(1, 0, nums.length - 1, index, value);

            // nums[start]부터 nums[n - 1]까지 조회
            Node result = query(
                    1,
                    0,
                    nums.length - 1,
                    start,
                    nums.length - 1
            );

            answer[i] = result.count[x];
        }

        return answer;
    }

    private void build(
            int node,
            int left,
            int right,
            int[] nums
    ) {
        if (left == right) {
            tree[node] = createLeaf(nums[left]);
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    private void update(
            int node,
            int left,
            int right,
            int index,
            int value
    ) {
        if (left == right) {
            tree[node] = createLeaf(value);
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    private Node query(
            int node,
            int left,
            int right,
            int queryLeft,
            int queryRight
    ) {
        // 현재 구간이 조회 범위 안에 완전히 포함되는 경우
        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        // 조회 범위가 왼쪽에만 있는 경우
        if (queryRight <= mid) {
            return query(
                    node * 2,
                    left,
                    mid,
                    queryLeft,
                    queryRight
            );
        }

        // 조회 범위가 오른쪽에만 있는 경우
        if (queryLeft > mid) {
            return query(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    queryLeft,
                    queryRight
            );
        }

        // 조회 범위가 양쪽에 걸친 경우
        Node leftResult = query(
                node * 2,
                left,
                mid,
                queryLeft,
                queryRight
        );

        Node rightResult = query(
                node * 2 + 1,
                mid + 1,
                right,
                queryLeft,
                queryRight
        );

        return merge(leftResult, rightResult);
    }

    private Node createLeaf(int value) {
        Node node = new Node(k);

        int remainder = value % k;

        node.product = remainder;
        node.count[remainder] = 1;

        return node;
    }

    private Node merge(Node left, Node right) {
        Node result = new Node(k);

        // 1. 왼쪽 구간 안에서 끝나는 prefix
        for (int remainder = 0; remainder < k; remainder++) {
            result.count[remainder] += left.count[remainder];
        }

        /*
         * 2. 오른쪽 구간까지 이어지는 prefix
         *
         * 합친 prefix의 곱
         * = 왼쪽 전체 곱 × 오른쪽 prefix의 곱
         */
        for (int remainder = 0; remainder < k; remainder++) {
            int newRemainder =
                    (left.product * remainder) % k;

            result.count[newRemainder] +=
                    right.count[remainder];
        }

        // 합친 구간 전체 곱
        result.product =
                (left.product * right.product) % k;

        return result;
    }
}
