package category.leetcode._2026.june;

public class June5th {

    public long totalWaviness(long num1, long num2) {
        return calc(num2) - calc(num1 - 1);
    }

    private long calc(long num) {
        if (num <= 0) {
            return 0;
        }

        char[] digits = String.valueOf(num).toCharArray();
        Node[][][][] memo = new Node[digits.length][3][11][11];

        return dfs(0, 0, -1, -1, true, digits, memo).sum;
    }

    private Node dfs(
            int pos,
            int status,
            int prev2,
            int prev1,
            boolean tight,
            char[] digits,
            Node[][][][] memo
    ) {
        if (pos == digits.length) {
            return new Node(1, 0);
        }

        int p2 = prev2 + 1;
        int p1 = prev1 + 1;

        if (!tight && memo[pos][status][p2][p1] != null) {
            return memo[pos][status][p2][p1];
        }

        int limit = tight ? digits[pos] - '0' : 9;
        long count = 0;
        long sum = 0;

        for (int i = 0; i <= limit; i++) {
            boolean nextTight = tight && i == limit;

            if (status == 0 && i == 0) {
                Node node = dfs(pos + 1, status, prev2, prev1, nextTight, digits, memo);
                count += node.count;
                sum += node.sum;
                continue;
            }

            int add = 0;
            int nextStatus;
            int nextPrev2;
            int nextPrev1;

            if (status == 0) {
                nextStatus = 1;
            } else if (status == 1) {
                nextStatus = 2;
            } else {
                if ((prev1 > i && prev1 > prev2) || (prev1 < i && prev1 < prev2)) {
                    add = 1;
                }

                nextStatus = 2;
            }

            nextPrev2 = prev1;
            nextPrev1 = i;
            Node node = dfs(pos + 1, nextStatus, nextPrev2, nextPrev1, nextTight, digits, memo);
            count += node.count;
            sum += node.sum + node.count * add;
        }

        Node result = new Node(count, sum);
        memo[pos][status][p2][p1] = result;

        return result;
    }

    private static class Node {

        private final long count;
        private final long sum;

        private Node(long count, long sum) {
            this.count = count;
            this.sum = sum;
        }
    }
}
