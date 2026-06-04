package category.leetcode._2026.june;

public class June4th {

    private char[] digits;
    private Node[][][][] memo;

    public int totalWaviness(int num1, int num2) {
        long answer = calc(num2) - calc(num1 - 1);

        return (int) answer;
    }

    private long calc(int n) {
        if (n <= 0) {
            return 0;
        }

        digits = String.valueOf(n).toCharArray();
        memo = new Node[digits.length][3][11][11];

        return dfs(0, 0, -1, -1, true).sum;
    }

    private Node dfs(int pos, int state, int prev2, int prev, boolean tight) {
        if (pos == digits.length) {
            return new Node(1, 0);
        }

        int p2 = prev2 + 1;
        int p1 = prev + 1;

        if (!tight && memo[pos][state][p2][p1] != null) {
            return memo[pos][state][p2][p1];
        }

        int limit = tight ? digits[pos] - '0' : 9;
        long count = 0;
        long sum = 0;

        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && d == limit;

            if (state == 0 && d == 0) {
                Node next = dfs(pos + 1, 0, -1, -1, nextTight);
                count += next.count;
                sum += next.sum;
                continue;
            }

            int add = 0;
            int nextState;
            int nextPrev2;
            int nextPrev;

            if (state == 0) {
                nextState = 1;
                nextPrev2 = -1;
                nextPrev = d;
            } else if (state == 1) {
                nextState = 2;
                nextPrev2 = prev;
                nextPrev = d;
            } else {
                if ((prev > prev2 && prev > d)
                        || (prev < prev2 && prev < d)) {
                    add = 1;
                }

                nextState = 2;
                nextPrev2 = prev;
                nextPrev = d;
            }

            Node next = dfs(pos + 1, nextState, nextPrev2, nextPrev, nextTight);
            count += next.count;
            sum += next.sum + next.count * add;
        }

        Node result = new Node(count, sum);

        if (!tight) {
            memo[pos][state][p2][p1] = result;
        }

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
