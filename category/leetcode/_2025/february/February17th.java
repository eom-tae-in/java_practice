package category.leetcode._2025.february;

public class February17th {

    public int numTilePossibilities(final String tiles) {
        int[] count = new int[26];

        for (final char t : tiles.toCharArray()) {
            ++count[t - 'A'];
        }

        return dfs(count);
    }

    private int dfs(final int[] count) {
        int possibleSequenceCount = 0;

        for (int i = 0; i < 26; ++i) {
            if (count[i] == 0) {
                continue;
            }

            count[i]--;
            possibleSequenceCount += 1 + dfs(count);
            count[i]++;
        }

        return possibleSequenceCount;
    }
}
