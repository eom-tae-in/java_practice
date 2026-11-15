package category.leetcode._2026.november;

public class November15th {

    private static final int MOD = 1_000_000_007;

    public int numOfSubarrays(int[] arr) {
        int evenCount = 1;
        int oddCount = 0;
        int parity = 0;
        long answer = 0;

        for (int num : arr) {
            parity = (parity + num) % 2;

            if (parity == 0) {
                answer += oddCount;
                evenCount++;
            } else {
                answer += evenCount;
                oddCount++;
            }

            answer %= MOD;
        }

        return (int) answer;
    }
}
