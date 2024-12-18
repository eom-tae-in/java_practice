package category.leetcode._2024.december;

public class December18th {

    public int[] finalPrices(final int[] prices) {
        int pricesLength = prices.length;
        int[] answer = new int[pricesLength];

        for (int i = 0; i < pricesLength; i++) {
            int currentPrice = prices[i];
            int nextMinPrice = 0;

            for (int j = i + 1; j < pricesLength; j++) {
                if (currentPrice >= prices[j]) {
                    nextMinPrice = prices[j];
                    break;
                }
            }

            answer[i] = currentPrice - nextMinPrice;
        }

        return answer;
    }
}
