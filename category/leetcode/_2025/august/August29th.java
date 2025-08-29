package category.leetcode._2025.august;

public class August29th {

    public long flowerGame(int n, int m) {
        int xEven = n / 2;
        int xOdd = (n + 1) / 2;
        int yEven = m / 2;
        int yOdd = (m + 1) / 2;

        return (long) xEven * yOdd + (long) xOdd * yEven;
    }
}
