package category.leetcode._2026.may;

public class May13th {

    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[2 * limit + 2];
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int lv = nums[left];
            int rv = nums[right];
            int min = Math.min(lv, rv);
            int max = Math.max(lv, rv);
            int sum = lv + rv;
            diff[2] += 2;

            diff[min + 1] -= 1;
            diff[max + limit + 1] += 1;

            diff[sum] -= 1;
            diff[sum + 1] += 1;

            left++;
            right--;
        }

        int cost = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 2; i < 2 * limit + 1; i++) {
            cost += diff[i];
            answer = Math.min(cost, answer);
        }

        return answer;
    }
}
