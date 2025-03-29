package category.leetcode._2025.march;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class March29th {

    private static final int MOD = 1_000_000_007;

    public int maximumScore(final List<Integer> nums, int k) {
        int n = nums.size();
        int mx = Collections.max(nums);
        int[] minPrimeFactors = sieveEratosthenes(mx + 1);
        int[] primeScores = getPrimeScores(nums, minPrimeFactors);
        int ans = 1;
        int[] left = new int[n];
        Arrays.fill(left, -1);
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && primeScores[stack.peek()] <= primeScores[i]) {
                left[stack.pop()] = i;
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && primeScores[stack.peek()] < primeScores[i]) {
                right[stack.pop()] = i;
            }

            stack.push(i);
        }

        int[][] numAndIndexes = new int[n][2];

        for (int i = 0; i < n; i++) {
            numAndIndexes[i][0] = nums.get(i);
            numAndIndexes[i][1] = i;
        }

        Arrays.sort(numAndIndexes, (a, b) -> {
            if (b[0] != a[0]) {
                return Integer.compare(b[0], a[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        for (int[] numAndIndex : numAndIndexes) {
            int num = numAndIndex[0];
            int i = numAndIndex[1];
            long rangeCount = (long) (i - left[i]) * (right[i] - i);
            long actualCount = Math.min(rangeCount, k);
            k -= (int) actualCount;
            ans = (int) ((ans * modPow(num, actualCount)) % MOD);

            if (k == 0) {
                break;
            }
        }

        return ans;
    }

    private long modPow(final long x, final long n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 1) {
            return x * modPow(x, n - 1) % MOD;
        }

        return modPow(x * x % MOD, n / 2);
    }

    private int[] sieveEratosthenes(final int n) {
        int[] minPrimeFactors = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            minPrimeFactors[i] = i;
        }
        for (int i = 2; i * i < n; i++) {
            if (minPrimeFactors[i] == i) {
                for (int j = i * i; j < n; j += i) {
                    minPrimeFactors[j] = Math.min(minPrimeFactors[j], i);
                }
            }
        }

        return minPrimeFactors;
    }

    private int[] getPrimeScores(final List<Integer> nums, final int[] minPrimeFactors) {
        int[] primeScores = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            primeScores[i] = getPrimeScore(nums.get(i), minPrimeFactors);
        }

        return primeScores;
    }

    private int getPrimeScore(int num, final int[] minPrimeFactors) {
        Set<Integer> primeFactors = new HashSet<>();

        while (num > 1) {
            int divisor = minPrimeFactors[num];
            primeFactors.add(divisor);

            while (num % divisor == 0) {
                num /= divisor;
            }
        }

        return primeFactors.size();
    }
}
