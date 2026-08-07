package category.leetcode._2026.august;

import java.util.Arrays;

public class August7th {

    private static final int[] PRIMES = new int[]{2, 3, 5, 7};
    private static final int MAX_PRIME = PRIMES[PRIMES.length - 1];

    public String smallestNumber(String num, long t) {
        int[] primeCount = new int[MAX_PRIME + 1];
        int numLength = num.length();
        int minLength = 0;
        int firstZeroIndexFromLeft = 0;

        for (int prime : PRIMES) {
            while (t % prime == 0) {
                t /= prime;
                primeCount[prime]++;
            }
        }

        if (t != 1) {
            return "-1";
        }

        minLength = getMinLength(primeCount);

        if (numLength < minLength) {
            return buildSuffix(primeCount, minLength, new char[minLength]);
        }

        char[] result = new char[numLength + 1];

        for (
                int i = 0;
                firstZeroIndexFromLeft < numLength && (result[++i] = num.charAt(firstZeroIndexFromLeft)) != '0';
                firstZeroIndexFromLeft++
        ) {
            logNum(primeCount, result[i], -1);
        }

        if (getMinLength(primeCount) == 0) {
            if (firstZeroIndexFromLeft == numLength) {
                return num;
            }

            Arrays.fill(result, ++firstZeroIndexFromLeft, result.length, '1');
            return new String(result, 1, numLength);
        }

        for (int last = numLength - 1, end = Math.min(firstZeroIndexFromLeft, last); end >= 0; end--) {
            for (
                    logNum(primeCount, result[end + 1], 1);
                    ++result[end + 1] <= '9';
                    logNum(primeCount, result[end + 1], 1)
            ) {
                logNum(primeCount, result[end + 1], -1);

                if (getMinLength(primeCount) <= last - end) {
                    return buildSuffix(primeCount, last - end, result);
                }
            }
        }

        return buildSuffix(primeCount, result.length, result);
    }

    private void logNum(int[] primeCount, int num, int value) {
        if (num < '2') {
            return;
        }

        if (num == '9') {
            primeCount[3] += value << 1;
        } else if (num == '4') {
            primeCount[2] += value << 1;
        } else if (num == '8') {
            primeCount[2] += value * 3;
        } else if (num == '6') {
            primeCount[2] += value;
            primeCount[3] += value;
        } else {
            primeCount[num - '0'] += value;
        }
    }

    private String buildSuffix(int[] primeCount, int targetLength, char[] result) {
        int index = result.length;

        while (primeCount[3] > 1) {
            primeCount[3] -= 2;
            result[--index] = '9';
        }

        while (primeCount[2] > 2) {
            primeCount[2] -= 3;
            result[--index] = '8';
        }

        while (primeCount[7]-- > 0) {
            result[--index] = '7';
        }

        if (primeCount[2] > 0 && primeCount[3] > 0) {
            result[--index] = '6';
            primeCount[2]--;
            primeCount[3]--;
        }

        while (primeCount[5]-- > 0) {
            result[--index] = '5';
        }

        while (primeCount[2] > 1) {
            primeCount[2] -= 2;
            result[--index] = '4';
        }

        while (primeCount[3] > 0) {
            primeCount[3]--;
            result[--index] = '3';
        }

        while (primeCount[2] > 0) {
            primeCount[2]--;
            result[--index] = '2';
        }

        while (index + targetLength != result.length) {
            result[--index] = '1';
        }

        return targetLength == result.length ? new String(result) : new String(result, 1, result.length - 1);
    }

    private int getMinLength(int[] primeCount) {
        int count2 = Math.max(0, primeCount[2]);
        int count3 = Math.max(0, primeCount[3]);
        int count23 = (count3 & 1) + (count2 % 3);

        return (count3 >> 1) + (count2 / 3)
                + Math.max(0, primeCount[7])
                + Math.max(0, primeCount[5])
                + (count23 == 3 ? 2 : count23 > 0 ? 1 : 0);
    }
}
