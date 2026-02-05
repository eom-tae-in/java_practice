package category.leetcode._2026.february;

public class February5th {

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; ++i) {
            answer[i] = nums[(i + nums[i] % n + n) % n];
        }

        return answer;
    }
}
