package category.leetcode._2025.july;

public class July9th {

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int[] gaps = getGaps(eventTime, startTime, endTime);
        int gapSum = 0;

        for (int i = 0; i <= k; i++) {
            gapSum += gaps[i];
        }

        int max = gapSum;

        for (int i = k + 1; i < gaps.length; i++) {
            gapSum -= gaps[i - (k + 1)];
            gapSum += gaps[i];
            max = Math.max(max, gapSum);
        }

        return max;
    }

    private int[] getGaps(int eventTime, int[] startTime, int[] endTime) {
        int length = startTime.length;
        int[] gaps = new int[length + 1];
        gaps[0] = startTime[0];

        for (int i = 1; i < length; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }

        gaps[length] = eventTime - endTime[length - 1];
        return gaps;
    }
}
