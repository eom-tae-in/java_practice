package category.leetcode._2026.july;

public class July7th {

    public long sumAndMultiply(int n) {
        long sum = 0;
        long total = 0;
        long placeValue = 1;

        while (n > 0) {
            int rest = n % 10;

            if (rest != 0) {
                sum += rest;
                total += placeValue * rest;
                placeValue *= 10;
            }

            n /= 10;
        }

        return total * sum;
    }
}
