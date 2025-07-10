package category.leetcode._2025.july;

public class July10th {

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int[] gaps = getGaps(eventTime, startTime, endTime);
        int eventLength = startTime.length;
        int[] leftMaxGaps = new int[eventLength + 1];
        int[] rightMaxGaps = new int[eventLength + 1];
        int answer = 0;
        leftMaxGaps[0] = gaps[0];
        rightMaxGaps[eventLength] = gaps[eventLength];

        for (int i = 1; i < eventLength + 1; i++) {
            leftMaxGaps[i] = Math.max(gaps[i], leftMaxGaps[i - 1]);
        }

        for (int i = eventLength - 1; i >= 0; i--) {
            rightMaxGaps[i] = Math.max(gaps[i], rightMaxGaps[i + 1]);
        }

        for (int i = 0; i < eventLength; i++) {
            int currentEventTime = endTime[i] - startTime[i];
            int nearGapTime = gaps[i] + gaps[i + 1];
            boolean canMoving = currentEventTime <= Math.max(i > 0 ? leftMaxGaps[i - 1] : 0,
                    i + 2 < eventLength + 1 ? rightMaxGaps[i + 2] : 0);
            answer = Math.max(answer, nearGapTime + (canMoving ? currentEventTime : 0));
        }

        return answer;
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
