package category.leetcode._2025.june;

public class June16th {

    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int numsLength = nums.length;
        int answer = -1;

        for (int i = 1; i < numsLength; i++) {
            int current = nums[i];

            if (current < min) {
                min = current;
            }

            if (current > min) {
                answer = Math.max(answer, current - min);
            }
        }

        return answer;
    }
}
