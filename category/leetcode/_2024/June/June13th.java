package category.leetcode._2024.June;

import java.util.Arrays;

public class June13th {

    public int minMovesToSeat(final int[] seats, final int[] students) {
        int answer = 0;
        int n = seats.length;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < n; i++) {
            answer += Math.abs(seats[i] - students[i]);
        }

        return answer;
    }
}
