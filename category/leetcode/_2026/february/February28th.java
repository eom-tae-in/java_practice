package category.leetcode._2026.february;

public class February28th {

    private static final int MOD = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long answer = 0;

        for (int i = 1; i <= n; ++i) {
            answer = ((answer << numberOfBits(i)) % MOD + i) % MOD;
        }

        return (int) answer;
    }

    private int numberOfBits(int n) {
        return (int) (Math.log(n) / Math.log(2)) + 1;
    }
}
