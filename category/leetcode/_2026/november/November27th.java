package category.leetcode._2026.november;

public class November27th {

    public int maximumSaleItems(int[][] items, int budget) {
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] dp = new int[budget + 1];

        for (int b = 0; b <= budget; b++) {
            dp[b] = b / minPrice;
        }

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (price > budget) {
                continue;
            }

            int firstPurchaseGain = 0;

            for (int[] other : items) {
                if (other[0] % factor == 0) {
                    firstPurchaseGain++;
                }
            }

            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + firstPurchaseGain);
            }
        }

        return dp[budget];
    }
}
