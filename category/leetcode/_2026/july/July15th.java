package category.leetcode._2026.july;

public class July15th {

    public int gcdOfOddEvenSums(int n) {
        int oddSum = n * n;
        int evenSum = n * (n + 1);

        return gcd(oddSum, evenSum);
    }

    private int gcd(int primary, int secondary) {
        while (secondary != 0) {
            int temp = primary % secondary;
            primary = secondary;
            secondary = temp;
        }

        return primary;
    }
}
