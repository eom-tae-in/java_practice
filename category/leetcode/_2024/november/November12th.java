package category.leetcode._2024.november;

import java.util.Arrays;

public class November12th {

    public int[] maximumBeauty(final int[][] items, final int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int itemRowLength = items.length;
        int maxBeauty = 0;
        int[] maxBeautyPerPrice = new int[itemRowLength + 1];

        for (int i = 0; i < itemRowLength; i++) {
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            maxBeautyPerPrice[i + 1] = maxBeauty;
        }

        int queryLength = queries.length;
        int[] answer = new int[queryLength];

        for (int i = 0; i < queryLength; i++) {
            int index = findGreaterPriceIndex(items, queries[i]);
            answer[i] = maxBeautyPerPrice[index];
        }

        return answer;
    }

    private int findGreaterPriceIndex(final int[][] items, final int price) {
        int left = 0;
        int right = items.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (items[mid][0] > price) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
