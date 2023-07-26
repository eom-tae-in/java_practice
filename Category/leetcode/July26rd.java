package Category.leetcode;

public class July26rd {

    public int minSpeedOnTime(final int[] dist, final double hour) {
        int min = 1;
        int max = (int) 1e7;
        while (min < max) {
            int mid = (min + max) >> 1;
            if (canArrive(dist, hour, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return canArrive(dist, hour, min) ? min : -1;
    }

    private boolean canArrive(final int[] dist, final double hour, final int speed) {
        int totalHour = 0;
        for (int i = 0; i < dist.length; i++) {
            totalHour += (i == dist.length - 1) ? (double) dist[i] / speed : Math.ceil((double) dist[i] / speed);
        }
        return totalHour <= hour;
    }
}
