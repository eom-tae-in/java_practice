package category.leetcode._2025.september;

public class September6th {

    public long minOperations(int[][] queries) {
        long answer = 0;

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            answer += (getMinOperationCount(right) - getMinOperationCount(left - 1) + 1) / 2;
        }

        return answer;
    }

    private long getMinOperationCount(int n) {
        long result = 0;
        int depth = 1;

        for (int i = 1; i <= n; i *= 4) {
            int right = Math.min(n, i * 4 - 1);
            result += (long) (right - i + 1) * depth++;
        }

        return result;
    }
}
