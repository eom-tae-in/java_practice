package category.leetcode._2025.june;

import java.util.Arrays;

public class June18th {

    public int[][] divideArray(int[] nums, int k) {
        int numsLength = nums.length;
        int[][] answer = new int[numsLength / 3][3];
        Arrays.sort(nums);

        for (int i = 0; i < numsLength / 3; i++) {
            int first = 0;

            for (int j = 0; j < 3; j++) {
                int current = nums[i * 3 + j];

                if (j == 0) {
                    first = current;
                } else {
                    if (current > first + k) {
                        return new int[0][0];
                    }
                }

                answer[i][j] = current;
            }
        }

        return answer;
    }
}
