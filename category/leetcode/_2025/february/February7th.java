package category.leetcode._2025.february;

import java.util.HashMap;
import java.util.Map;

public class February7th {

    public int[] queryResults(final int limit, final int[][] queries) {
        Map<Integer, Integer> ballAndColor = new HashMap<>();
        Map<Integer, Integer> colorAndCount = new HashMap<>();
        int queriesLength = queries.length;
        int[] answer = new int[queriesLength];

        for (int i = 0; i < queriesLength; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballAndColor.containsKey(ball)) {
                int prevColor = ballAndColor.get(ball);

                if (colorAndCount.merge(prevColor, -1, Integer::sum) == 0) {
                    colorAndCount.remove(prevColor);
                }
            }

            ballAndColor.put(ball, color);
            colorAndCount.merge(color, 1, Integer::sum);
            answer[i] = colorAndCount.size();
        }

        return answer;
    }
}
