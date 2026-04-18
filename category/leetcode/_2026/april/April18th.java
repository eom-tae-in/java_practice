package category.leetcode._2026.april;

public class April18th {

    public int mirrorDistance(int n) {
        int reverse = getReverse(n);

        return Math.abs(n - reverse);
    }

    private int getReverse(int num) {
        int reverse = 0;

        while (num > 0) {
            reverse *= 10;
            reverse += num % 10;
            num /= 10;
        }

        return reverse;
    }
}
