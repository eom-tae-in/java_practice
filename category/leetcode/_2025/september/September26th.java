package category.leetcode._2025.september;

import java.util.Arrays;

public class September26th {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        int n = nums.length;

        for (int k = n - 1; k >= 0; k--) {
            int i = 0;
            int j = k - 1;

            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    answer += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }

        return answer;
    }
}
