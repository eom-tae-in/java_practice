package category.leetcode._2025.june;

public class June1st {

    public long distributeCandies(int n, int limit) {
        int exceed = limit + 1;
        long oneExceedCase = ways(n - exceed);
        long twoExceedCase = ways(n - 2 * exceed);
        long threeExceedCase = ways(n - 3 * exceed);
        long totalCase = ways(n);

        return totalCase - 3 * oneExceedCase + 3 * twoExceedCase - threeExceedCase;
    }

    private long ways(int n) {
        if (n < 0) {
            return 0;
        }

        return combine(n + 2, 2);
    }

    private long combine(int n, int k) {
        long result = 1;

        for (int i = 1; i <= k; i++) {
            result = result * (n + 1 - i) / i;
        }

        return result;
    }
}
