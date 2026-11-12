package category.leetcode._2026.november;

public class November12th {

    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        int prevStatus = 0;
        int answer = 1;
        int currSize = 1;

        for (int i = 0; i < n - 1; i++) {
            int currStatus = 0;

            if (nums[i] < nums[i + 1]) {
                currStatus = 1;
            } else if (nums[i] > nums[i + 1]) {
                currStatus = -1;
            }

            if (currStatus != 0 && currStatus == prevStatus) {
                currSize++;
            } else if (currStatus == 0) {
                currSize = 1;
            } else {
                currSize = 2;
            }

            if (currSize > answer) {
                answer = currSize;
            }

            prevStatus = currStatus;
        }

        return answer;
    }
}
