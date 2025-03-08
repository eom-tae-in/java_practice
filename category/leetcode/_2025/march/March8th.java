package category.leetcode._2025.march;

public class March8th {

    public int minimumRecolors(final String blocks, final int k) {
        int blackCount = 0;
        int maxBlackCount = 0;
        int length = blocks.length();

        for (int i = 0; i < length; i++) {
            if (blocks.charAt(i) == 'B') {
                blackCount++;
            }
            if (i >= k && blocks.charAt(i - k) == 'B') {
                blackCount--;
            }

            maxBlackCount = Math.max(maxBlackCount, blackCount);
        }

        return k - maxBlackCount;
    }
}
