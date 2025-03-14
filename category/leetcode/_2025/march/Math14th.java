package category.leetcode._2025.march;

public class Math14th {

    public int maximumCandies(final int[] candies, final long k) {
        long total = 0;
        int answer = 0;

        for (int candy : candies) {
            total += candy;
        }

        int left = 1;
        int right = (int) (total / k);

        if (right == 0) {
            return 0;
        }

        while (left <= right) {
            int mid = (left + right + 1) / 2;
            long currentChildrenNum = 0;

            for (int candy : candies) {
                currentChildrenNum += candy / mid;
            }

            if (currentChildrenNum >= k) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
