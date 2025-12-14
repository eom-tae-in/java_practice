package category.leetcode._2025.december;

public class December14th {

    public int numberOfWays(String corridor) {
        int mod = 1_000_000_007;
        long answer = 1;
        int prevSeat = -1;
        int numSeats = 0;

        for (int i = 0; i < corridor.length(); ++i) {
            if (corridor.charAt(i) == 'S') {
                if (++numSeats > 2 && numSeats % 2 == 1) {
                    answer = answer * (i - prevSeat) % mod;
                }

                prevSeat = i;
            }
        }

        return numSeats > 1 && numSeats % 2 == 0 ? (int) answer : 0;
    }
}
