package category.leetcode._2025.july;

public class July25th {

    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] count = new int[101];
        int answer = 0;

        for (int num : nums) {
            max = Math.max(max, num);

            if (num > 0 && count[num] == 0) {
                count[num]++;
                answer += num;
            }
        }

        if (max < 0) {
            return max;
        }

        return answer;
    }
}
