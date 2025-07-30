package category.leetcode._2025.july;

public class July30th {

    public int longestSubarray(int[] nums) {
        int max = 0;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int count = 0;
        int answer = 0;

        for (int num : nums) {
            if (num == max) {
                count++;
                answer = Math.max(answer, count);
            } else {
                count = 0;
            }
        }

        return answer;
    }
}
