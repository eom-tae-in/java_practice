package category.leetcode._2024.july;

public class July8th {

    public int findTheWinner(final int n, final int k) {
        if (n == 1) {
            return 1;
        }
        return (findTheWinner(n - 1, k) + k - 1) % n + 1;
    }
}
