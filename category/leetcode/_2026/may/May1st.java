package category.leetcode._2026.may;

public class May1st {

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            sum += curr;
            f += i * curr;
        }

        int answer = f;

        for (int i = n - 1; i >= 0; i--) {
            f += sum - n * nums[i];
            answer = Math.max(answer, f);
        }

        return answer;
    }
}
