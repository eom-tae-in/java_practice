package category.leetcode._2026.february;

public class February1st {

    public int minimumCost(int[] nums) {
        int answer = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int curr = nums[i] + nums[j];
                answer = Math.min(answer, curr);
            }
        }

        return answer + nums[0];
    }
}
