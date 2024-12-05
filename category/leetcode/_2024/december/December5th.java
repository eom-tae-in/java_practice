package category.leetcode._2024.december;

import java.util.LinkedList;
import java.util.Queue;

public class December5th {

    public boolean canChange(final String start, final String target) {
        Queue<int[]> startQueue = new LinkedList<>();
        Queue<int[]> targetQueue = new LinkedList<>();
        int strLength = start.length();

        for (int i = 0; i < strLength; i++) {
            char currentStart = start.charAt(i);
            char currentTarget = target.charAt(i);

            if (currentStart == 'L' || currentStart == 'R') {
                startQueue.offer(new int[]{currentStart, i});
            }

            if (currentTarget == 'L' || currentTarget == 'R') {
                targetQueue.offer(new int[]{currentTarget, i});
            }
        }

        if (startQueue.size() != targetQueue.size()) {
            return false;
        }

        while (!startQueue.isEmpty()) {
            int[] polledStart = startQueue.poll();
            char startChar = (char) polledStart[0];
            int startIndex = polledStart[1];

            int[] polledTarget = targetQueue.poll();
            char targetChar = (char) polledTarget[0];
            int targetIndex = polledTarget[1];

            if (startChar != targetChar) {
                return false;
            }

            if (startChar == 'L' && startIndex < targetIndex) {
                return false;
            }

            if (startChar == 'R' && startIndex > targetIndex) {
                return false;
            }
        }

        return true;
    }
}
