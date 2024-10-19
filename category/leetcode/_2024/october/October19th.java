package category.leetcode._2024.october;

public class October19th {

    public char findKthBit(final int n, final int k) {
        if (n == 1) {
            return '0';
        }

        int midIndex = (int) Math.pow(2, n - 1);

        if (k == midIndex) {
            return '1';
        }

        if (k < midIndex) {
            return findKthBit(n - 1, k);
        }

        return findKthBit(n - 1, midIndex * 2 - k) == '0' ? '1' : '0';
    }
}
