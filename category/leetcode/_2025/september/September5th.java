package category.leetcode._2025.september;

public class September5th {

    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 1; i <= 60; i++) {
            long remain = num1 - i * (long) num2;

            if (remain < 0) {
                return -1;
            }

            if (Long.bitCount(remain) <= i && i <= remain) {
                return i;
            }
        }

        return -1;
    }
}
