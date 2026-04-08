package category.leetcode._2026.april;

public class April8th {

    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int step = query[2];
            int value = query[3];

            for (int i = left; i <= right; i += step) {
                long curr = nums[i];
                nums[i] = (int) ((curr * value) % MOD);
            }
        }

        int answer = 0;

        for (int num : nums) {
            answer ^= num;
        }

        return answer;
    }
}
