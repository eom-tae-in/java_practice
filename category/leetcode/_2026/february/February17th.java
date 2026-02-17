package category.leetcode._2026.february;

import java.util.ArrayList;
import java.util.List;

public class February17th {

    public List<String> readBinaryWatch(int turnedOn) {
        int[] hours = {8, 4, 2, 1};
        int[] minutes = {32, 16, 8, 4, 2, 1};
        List<String> answer = new ArrayList<>();
        backtrack(0, 0, 0, turnedOn, hours, minutes, answer);

        return answer;
    }

    private void backtrack(
            int currentIndex,
            int hour,
            int minute,
            int turnedOn,
            int[] hours,
            int[] minutes,
            List<String> answer
    ) {
        if (turnedOn == 0) {
            answer.add(hour + ":" + (minute < 10 ? "0" : "") + minute);

            return;
        }

        for (int i = currentIndex; i < hours.length + minutes.length; i++) {
            if (i < 4 && hour + hours[i] < 12) {
                backtrack(i + 1, hour + hours[i], minute, turnedOn - 1, hours, minutes, answer);
            }

            if (i >= 4 && minute + minutes[i - 4] < 60) {
                backtrack(i + 1, hour, minute + minutes[i - 4], turnedOn - 1, hours, minutes, answer);
            }
        }
    }
}
