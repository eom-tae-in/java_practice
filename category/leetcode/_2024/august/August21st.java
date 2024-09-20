package category.leetcode._2024.august;

public class August21st {

    public int strangePrinter(final String s) {
        final int n = s.length();
        int[][] mem = new int[n][n];

        return strangePrinter(s, 0, n - 1, mem);
    }


    private int strangePrinter(final String s, final int i, final int j, final int[][] mem) {
        if (i > j) {
            return 0;
        }
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        mem[i][j] = strangePrinter(s, i + 1, j, mem) + 1;
        for (int k = i + 1; k <= j; k++) {
            if (s.charAt(k) == s.charAt(i)) {
                mem[i][j] = Math.min(mem[i][j], strangePrinter(s, i, k - 1, mem) + strangePrinter(s, k + 1, j, mem));
            }
        }

        return mem[i][j];
    }
}
