package category.leetcode._2025.march;

public class March19th {

    public int minOperations(final int[] nums) {
        int answer = 0;
        int numsLength = nums.length;

        for (int i = 0; i < numsLength; i++) {
            int current = nums[i];

            if (current == 0) {
                if (i > numsLength - 3) {
                    return -1;
                } else {
                    nums[i] = 0;
                    nums[i + 1] = nums[i + 1] == 1 ? 0 : 1;
                    nums[i + 2] = nums[i + 2] == 1 ? 0 : 1;
                    answer++;
                }
            }
        }

        return answer;
    }
}
