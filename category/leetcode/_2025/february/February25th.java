package category.leetcode._2025.february;

public class February25th {

    public int numOfSubarrays(final int[] arr) {
        int odd = 0;
        int even = 0;
        int answer = 0;
        int mod = 1_000_000_007;

        for (int num : arr) {
            if (num % 2 == 1) {
                int temp = odd;
                odd = even + 1;
                even = temp;
            } else {
                even++;
            }

            answer = (answer + odd) % mod;
        }

        return answer;
    }
}
