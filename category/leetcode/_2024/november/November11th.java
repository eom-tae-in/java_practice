package category.leetcode._2024.november;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class November11th {

    public boolean primeSubOperation(final int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return true;
        }

        List<Integer> primeNumbers = getPrimeNumbers(1000);
        int prevNum = 0;

        for (int num : nums) {
            int index = findGraterOrEqualIndex(num - prevNum, primeNumbers);
            if (index > 0) {
                num -= primeNumbers.get(index - 1);
            }
            if (prevNum >= num) {
                return false;
            }
            prevNum = num;
        }

        return true;
    }

    private List<Integer> getPrimeNumbers(final int num) {
        boolean[] isPrime = new boolean[num + 1];
        List<Integer> primeNumbers = new ArrayList<>();
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= num; i++) {
            for (int j = i * i; j <= num; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = 2; i <= num; i++) {
            if (isPrime[i]) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }

    private int findGraterOrEqualIndex(final int num, final List<Integer> primeNumbers) {
        int index = Collections.binarySearch(primeNumbers, num);
        return index < 0 ? -index - 1 : index;
    }
}
