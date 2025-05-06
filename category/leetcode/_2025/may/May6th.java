package category.leetcode._2025.may;

public class May6th {

    public int[] buildArray(final int[] nums) {
        int numsLength = nums.length;
        int[] answer = new int[numsLength];

        for (int i = 0; i < numsLength; i++) {
            answer[i] = nums[nums[i]];
        }

        return answer;
    }
}
