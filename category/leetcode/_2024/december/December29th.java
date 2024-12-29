package category.leetcode._2024.december;

public class December29th {

    private static final int K_MOD = 1_000_000_007;

    public int numWays(final String[] words, final String target) {
        int wordLength = words[0].length();
        Integer[][] mem = new Integer[target.length()][wordLength];
        int[][] counts = new int[wordLength][26];

        for (int i = 0; i < wordLength; ++i) {
            for (String word : words) {
                counts[i][word.charAt(i) - 'a']++;
            }
        }

        return numWays(target, 0, 0, counts, mem);
    }

    private int numWays(
            final String target,
            final int i,
            final int j,
            final int[][] counts,
            final Integer[][] mem
    ) {
        if (i == target.length()) {
            return 1;
        }
        if (j == counts.length) {
            return 0;
        }
        if (mem[i][j] != null) {
            return mem[i][j];
        }
        return mem[i][j] = (int) ((numWays(target, i + 1, j + 1, counts, mem) *
                (long) (counts[j][target.charAt(i) - 'a']) +
                numWays(target, i, j + 1, counts, mem)) %
                K_MOD);
    }
}
