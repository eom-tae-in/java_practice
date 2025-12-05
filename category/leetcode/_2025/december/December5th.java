package category.leetcode._2025.december;

public class December5th {

    public int countPartitions(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        int answer = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            int rightSum = totalSum - leftSum;

            if ((rightSum - leftSum) % 2 == 0) {
                answer++;
            }
        }

        return answer;
    }
}
