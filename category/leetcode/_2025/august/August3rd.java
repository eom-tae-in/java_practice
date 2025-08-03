package category.leetcode._2025.august;

public class August3rd {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0;
        int sum = 0;
        int maxSum = 0;

        while (left < fruits.length && fruits[left][0] < startPos - k) {
            left++;
        }

        for (int right = left; right < fruits.length && fruits[right][0] <= startPos + k; right++) {
            sum += fruits[right][1];

            while (Math.min(startPos - 2 * fruits[left][0] + fruits[right][0],
                    2 * fruits[right][0] - fruits[left][0] - startPos) > k) {
                sum -= fruits[left++][1];
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
