package category.leetcode._2025.may;

public class May27th {

    public int differenceOfSums(final int n, final int m) {
        int total = 0;
        int divisibleTotal = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                divisibleTotal += i;
            } else {
                total += i;
            }
        }

        return total - divisibleTotal;
    }
}
