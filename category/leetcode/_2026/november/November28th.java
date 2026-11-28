package category.leetcode._2026.november;

import java.util.Arrays;
import java.util.Comparator;

public class November28th {

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] frequency = new int[n + 1];
        int[] bonusLimit = new int[n + 1];

        for (int[] item : items) {
            frequency[item[0]]++;
        }

        for (int factor = 1; factor <= n; factor++) {
            if (frequency[factor] == 0) {
                continue;
            }

            int count = 0;

            for (int multiple = factor; multiple <= n; multiple += factor) {
                count += frequency[multiple];
            }

            bonusLimit[factor] = count - 1;
        }

        Arrays.sort(items, Comparator.comparingInt(item -> item[1]));
        int minPrice = items[0][1];
        int total = 0;

        for (int[] item : items) {
            int price = item[1];

            if (price > budget || price >= 2L * minPrice) {
                break;
            }

            int count = Math.min(bonusLimit[item[0]], budget / price);
            total += 2 * count;
            budget -= price * count;
        }

        return total + budget / minPrice;
    }
}
