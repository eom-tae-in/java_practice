package category.leetcode.october.tweenty_third;

public class October23rd {

    public boolean isPowerOfFour(int n) {
        return n > 0 && Integer.bitCount(n) == 1 && (n - 1) % 3 == 0;
    }
}
