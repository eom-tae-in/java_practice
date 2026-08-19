package category.leetcode._2026.august;

import java.util.HashMap;
import java.util.Map;

public class August19th {

    private final Map<Integer, Integer> map = new HashMap<>();

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int seat = reservedSeat[1];
            map.merge(row, 1 << (seat - 2), (current, added) -> current | added);
        }

        int answer = (n - map.size()) * 2;
        int leftSeat = 0b00001111;
        int midSeat = 0b00111100;
        int rightSeat = 0b11110000;

        for (int mask : map.values()) {
            boolean canSeatLeft = (mask & leftSeat) == 0;
            boolean canSeatRight = (mask & rightSeat) == 0;

            if (canSeatLeft) {
                answer++;
            }

            if (canSeatRight) {
                answer++;
            }

            if (!canSeatLeft && !canSeatRight && (mask & midSeat) == 0) {
                answer++;
            }
        }

        return answer;
    }
}
