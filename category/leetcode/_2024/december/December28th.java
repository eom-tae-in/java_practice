package category.leetcode._2024.december;

public class December28th {

    public int[] maxSumOfThreeSubarrays(final int[] nums, final int k) {
        int n = nums.length - k + 1;
        int[] sums = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int sum = 0;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (i >= k)
                sum -= nums[i - k];
            if (i >= k - 1)
                sums[i - k + 1] = sum;
        }

        int maxIndex = 0;

        for (int i = 0; i < n; ++i) {
            if (sums[i] > sums[maxIndex])
                maxIndex = i;
            left[i] = maxIndex;
        }

        maxIndex = n - 1;

        for (int i = n - 1; i >= 0; --i) {
            if (sums[i] >= sums[maxIndex])
                maxIndex = i;
            right[i] = maxIndex;
        }

        int[] answer = {-1, -1, -1};

        for (int i = k; i + k < n; ++i)
            if (answer[0] == -1 ||
                    sums[answer[0]] + sums[answer[1]] + sums[answer[2]] < sums[left[i - k]] + sums[i] + sums[right[i + k]]) {
                answer[0] = left[i - k];
                answer[1] = i;
                answer[2] = right[i + k];
            }

        return answer;
    }
}
