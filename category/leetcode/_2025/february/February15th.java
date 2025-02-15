package category.leetcode._2025.february;

public class February15th {

    public int punishmentNumber(final int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (isPunishmentNumber(0, 0, 0, i, String.valueOf(i * i))) {
                answer += i * i;
            }
        }

        return answer;
    }

    private boolean isPunishmentNumber(
            final int accumulate,
            final int running,
            final int runningIndex,
            final int target,
            final String numChars
    ) {
        if (runningIndex == numChars.length()) {
            return target == accumulate + running;
        }

        int current = numChars.charAt(runningIndex) - '0';
        return isPunishmentNumber(accumulate, running * 10 + current, runningIndex + 1, target, numChars) ||
                isPunishmentNumber(accumulate + running, current, runningIndex + 1, target, numChars);
    }
}
