package category.leetcode._2026.july;

public class July25th {

    public int maxProduct(int n) {
        int primary = 0;
        int secondary = 0;

        while (n > 0) {
            int rest = n % 10;

            if (rest > primary) {
                secondary = primary;
                primary = rest;
            } else if (rest > secondary) {
                secondary = rest;
            }

            n /= 10;
        }

        return primary * secondary;
    }
}
