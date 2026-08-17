package category.leetcode._2026.august;

public class August17th {

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];
        int[][] maxLeft = new int[n][n];
        int[][] maxRight = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            maxLeft[i][i] = stoneValue[i];
            maxRight[i][i] = stoneValue[i];
            int split = i - 1;

            for (int j = i + 1; j < n; j++) {
                while (split + 1 < j) {
                    int nextSplit = split + 1;
                    int leftSum = getSum(prefixSum, i, nextSplit);
                    int rightSum = getSum(prefixSum, nextSplit + 1, j);

                    if (leftSum > rightSum) {
                        break;
                    }

                    split++;
                }

                int bestScore = 0;

                if (split >= i) {
                    bestScore = maxLeft[i][split];
                }

                int rightStart = split + 2;

                if (split >= i) {
                    int leftSum = getSum(prefixSum, i, split);
                    int rightSum = getSum(prefixSum, split + 1, j);

                    if (leftSum == rightSum) {
                        rightStart = split + 1;
                    }
                }

                if (rightStart <= j) {
                    bestScore = Math.max(bestScore, maxRight[rightStart][j]);
                }

                dp[i][j] = bestScore;
                int totalSum = getSum(prefixSum, i, j);
                int currentValue = totalSum + dp[i][j];
                maxLeft[i][j] = Math.max(maxLeft[i][j - 1], currentValue);
                maxRight[i][j] = Math.max(maxRight[i + 1][j], currentValue);
            }
        }

        return dp[0][n - 1];
    }

    private int getSum(int[] prefixSum, int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
