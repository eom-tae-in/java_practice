package category.leetcode._2024.August;

import java.util.Arrays;

public class August20th {

    public int stoneGameII(final int[] piles) {
        int n = piles.length;
        int[][] memory = new int[n][n];
        int[] suffix = new int[n];
        Arrays.stream(memory)
                .forEach(row -> Arrays.fill(row, -1));
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return dfs(0, 1, suffix, memory);
    }

    private int dfs(final int index, final int m, final int[] suffix, final int[][] memory) {
        if (index + 2 * m >= suffix.length) {
            return suffix[index];
        }
        if (memory[index][m] != -1) {
            return memory[index][m];
        }
        int opponent = suffix[index];
        for (int x = 1; x <= 2 * m; x++) {
            opponent = Math.min(opponent, dfs(index + x, Math.max(m, x), suffix, memory));
        }

        return memory[index][m] = suffix[index] - opponent;
    }
}
