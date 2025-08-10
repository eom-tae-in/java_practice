package category.leetcode._2025.august;

public class August10th {

    public boolean reorderedPowerOf2(int n) {
        int count = digitsSignature(n);

        for (int i = 0; i < 30; i++) {
            if (digitsSignature(1 << i) == count) {
                return true;
            }
        }

        return false;
    }

    private int digitsSignature(int n) {
        int result = 0;

        while (n > 0) {
            result += (int) Math.pow(10, n % 10);
            n /= 10;
        }

        return result;
    }
}
