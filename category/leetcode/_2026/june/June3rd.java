package category.leetcode._2026.june;

public class June3rd {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landLen = landStartTime.length;
        int waterLen = waterStartTime.length;
        int landMin = Integer.MAX_VALUE;
        int waterMin = Integer.MAX_VALUE;

        for (int i = 0; i < landLen; i++) {
            landMin = Math.min(landMin, landStartTime[i] + landDuration[i]);
        }

        for (int i = 0; i < waterLen; i++) {
            waterMin = Math.min(waterMin, waterStartTime[i] + waterDuration[i]);
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < landLen; i++) {
            answer = Math.min(answer, Math.max(waterMin, landStartTime[i]) + landDuration[i]);
        }

        for (int i = 0; i < waterLen; i++) {
            answer = Math.min(answer, Math.max(landMin, waterStartTime[i]) + waterDuration[i]);
        }

        return answer;
    }
}
