package category.leetcode._2025.february;

public class February4th {

    public int maxAscendingSum(final int[] nums) {
        int answer = nums[0];
        int numsLength = nums.length;
        int sum = nums[0];

        for (int i = 1; i < numsLength; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
