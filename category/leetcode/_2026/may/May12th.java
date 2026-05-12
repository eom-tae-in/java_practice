package category.leetcode._2026.may;

import java.util.Arrays;

public class May12th {

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0] - (a[1] - a[0])));
        int energy = 0;
        int answer = 0;

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            if (energy < minimum) {
                int need = minimum - energy;
                energy += need;
                answer += need;
            }

            energy -= actual;
        }

        return answer;
    }
}
