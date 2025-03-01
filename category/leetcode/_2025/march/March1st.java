package category.leetcode._2025.march;

public class March1st {

    public int[] applyOperations(final int[] nums) {
        int numsLength = nums.length;
        int[] answer = new int[numsLength];

        for (int i = 0; i < numsLength - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                answer[index++] = num;
            }
        }

        return answer;
    }
}
