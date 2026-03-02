package category.leetcode._2026.march;

public class March2nd {

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int answer = 0;
        int[] suffixZeros = new int[n];

        for (int i = 0; i < grid.length; i++) {
            suffixZeros[i] = getSuffixZeroCount(grid[i]);
        }

        for (int i = 0; i < n; i++) {
            int neededZeros = n - 1 - i;
            int j = getFirstRowWithEnoughZeros(suffixZeros, i, neededZeros);

            if (j == -1) {
                return -1;
            }

            for (int k = j; k > i; k--) {
                suffixZeros[k] = suffixZeros[k - 1];
            }

            answer += j - i;
        }

        return answer;
    }

    private int getSuffixZeroCount(int[] row) {
        for (int i = row.length - 1; i >= 0; i--) {
            if (row[i] == 1) {
                return row.length - i - 1;
            }
        }

        return row.length;
    }

    private int getFirstRowWithEnoughZeros(int[] suffixZeros, int i, int neededZeros) {
        for (int j = i; j < suffixZeros.length; j++) {
            if (suffixZeros[j] >= neededZeros) {
                return j;
            }
        }

        return -1;
    }
}
