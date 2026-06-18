package category.leetcode._2026.june;

public class June18th {

    public double angleClock(int hour, int minutes) {
        double absAngle = Math.abs(getMinutesAngle(minutes) - getHourAngle(hour, minutes));

        if (absAngle > 180) {
            absAngle = 360 - absAngle;
        }

        return absAngle;
    }

    private double getMinutesAngle(int minutes) {
        return (double) minutes * 6;
    }

    private double getHourAngle(int hour, int minutes) {
        double angle = 30 * hour;
        angle += (minutes / 60.0) * 30;

        return angle;
    }
}
