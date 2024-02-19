package category.leetcode._2024.february;

public class February19th {

    public boolean isPowerOfTwo(final int n) {
        return n >= 0 && Integer.bitCount(n) == 1;
    }
}
