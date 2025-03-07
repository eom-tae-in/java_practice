package category.leetcode._2025.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class March7th {

    public int[] closestPrimes(final int left, final int right) {
        boolean[] isPrime = sieveEratosthenes(right);
        List<Integer> primeNums = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primeNums.add(i);
            }
        }

        if (primeNums.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int primary = 0;
        int secondary = 0;

        for (int i = 0; i < primeNums.size() - 1; i++) {
            if (primeNums.get(i + 1) - primeNums.get(i) < minDiff) {
                minDiff = primeNums.get(i + 1) - primeNums.get(i);
                primary = primeNums.get(i);
                secondary = primeNums.get(i + 1);
            }
        }

        return new int[]{primary, secondary};
    }

    private boolean[] sieveEratosthenes(final int num) {
        boolean[] isPrime = new boolean[num + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= num; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= num; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
