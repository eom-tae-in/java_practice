package category.leetcode._2024.May;

public class May19th {

    public long maximumValueSum(final int[] nums, final int k, final int[][] edges) {
        long sum = 0;
        int changedCount = 0;
        int minChangeDiff = Integer.MAX_VALUE;

        for (final int num : nums) {
            sum += Math.max(num, num ^ k);
            changedCount += ((num ^ k) > num) ? 1 : 0;
            minChangeDiff = Math.min(minChangeDiff, Math.abs(num - (num ^ k)));
        }

        return changedCount % 2 == 0 ? sum : sum - minChangeDiff;
    }
}
