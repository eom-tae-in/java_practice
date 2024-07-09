package category.leetcode._2024.July;

public class July9th {

    public double averageWaitingTime(final int[][] customers) {
        long answer = 0;
        int prevTime = 0;
        for (int[] customer : customers) {
            int arrival = customer[0];
            int time = customer[1];
            if (arrival >= prevTime) {
                answer += time;
                prevTime = arrival + time;
            } else {
                answer += (prevTime - arrival) + time;
                prevTime += time;
            }
        }

        return (double) answer / customers.length;
    }
}
