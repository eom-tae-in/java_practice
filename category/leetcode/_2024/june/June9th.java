package category.leetcode._2024.june;

public class June9th {

    public int subarraysDivByK(final int[] nums, final int k) {
        int answer = 0;
        int sum = 0;
        int[] count = new int[k];
        count[0] = 1;
        for (int num : nums) {
            sum = (sum + num % k + k) % k;
            answer += count[sum];
            count[sum]++;
        }

        return answer;
    }
}
