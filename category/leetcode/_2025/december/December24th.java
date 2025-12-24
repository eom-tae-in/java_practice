package category.leetcode._2025.december;

import java.util.Arrays;

public class December24th {

    public int minimumBoxes(int[] apple, int[] capacity) {
        int appleSum = 0;

        for (int i = 0; i < apple.length; i++) {
            appleSum += apple[i];
        }

        int idx = capacity.length - 1;
        int answer = 0;
        Arrays.sort(capacity);

        while (appleSum > 0) {
            appleSum -= capacity[idx--];
            answer++;
        }

        return answer;
    }
}
