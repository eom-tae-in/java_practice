package category.leetcode._2025.december;

public class December15th {

    public long getDescentPeriods(int[] prices) {
        int prev = prices[0];
        int contiguous = 1;
        long answer = prices.length;

        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];

            if (prev - 1 == curr) {
                answer += contiguous++;
            } else {
                contiguous = 1;
            }

            prev = curr;
        }

        return answer;
    }
}
