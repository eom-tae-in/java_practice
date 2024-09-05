package category.leetcode._2024.september;

import java.util.Arrays;

public class September5th {

    public int[] missingRolls(final int[] rolls, final int mean, final int n) {
        final int targetSum = (rolls.length + n) * mean;
        int missingSum = targetSum - Arrays.stream(rolls)
                .sum();
        if (missingSum > n * 6 || missingSum < n) {
            return new int[]{};
        }
        int[] answer = new int[n];
        Arrays.fill(answer, missingSum / n);
        missingSum %= n;
        for (int i = 0; i < missingSum; ++i) {
            ++answer[i];
        }

        return answer;
    }
}
