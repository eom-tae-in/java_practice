package category.leetcode._2025.december;

public class December18th {

    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] prefixProfit = new long[n + 1];
        long[] prefixPrice = new long[n + 1];
        long total = 0;

        for (int i = 0; i < n; i++) {
            total += prices[i] * strategy[i];
            prefixProfit[i + 1] = total;
            prefixPrice[i + 1] = prefixPrice[i] + prices[i];
        }

        long answer = total;

        for (int i = 0; i <= n - k; i++) {
            long origin = prefixProfit[i + k] - prefixProfit[i];
            long curr = prefixPrice[i + k] - prefixPrice[i + (k / 2)];
            answer = Math.max(answer, total - origin + curr);
        }

        return answer;
    }
}
