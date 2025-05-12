package category.leetcode._2025.may;

import java.util.ArrayList;
import java.util.List;

public class May12th {

    public int[] findEvenNumbers(final int[] digits) {
        int[] digitCounts = new int[10];
        List<Integer> uniqueNumbers = new ArrayList<>();

        for (int digit : digits) {
            digitCounts[digit]++;
        }

        for (int a = 1; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c <= 8; c += 2) {
                    if (digitCounts[a] > 0
                            && digitCounts[b] > (a == b ? 1 : 0)
                            && digitCounts[c] > (a == c ? 1 : 0) + (b == c ? 1 : 0)) {
                        uniqueNumbers.add(a * 100 + b * 10 + c);
                    }
                }
            }
        }

        int[] answer = new int[uniqueNumbers.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = uniqueNumbers.get(i);
        }

        return answer;
    }
}
