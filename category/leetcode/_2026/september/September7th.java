package category.leetcode._2026.september;

public class September7th {

    private static final int MOD = 1_000_000_007;

    public int distinctSubseqII(String s) {
        long[] edge = new long[26];
        long total = 0;

        for (char ch : s.toCharArray()) {
            int curr = ch - 'a';
            long newEdge = total + 1;
            total = (total - edge[curr] + newEdge + MOD) % MOD;
            edge[curr] = newEdge;
        }

        return (int) total;
    }
}
