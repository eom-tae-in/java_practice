package category.leetcode._2026.june;

public class June2nd {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int answer = Integer.MAX_VALUE;
        int landLen = landStartTime.length;
        int waterLen = waterStartTime.length;

        for (int i = 0; i < landLen; i++) {
            for (int j = 0; j < waterLen; j++) {
                int landFinish = landStartTime[i] + landDuration[i];
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int finish1 = waterStart + waterDuration[j];
                int waterFinish = waterStartTime[j] + waterDuration[j];
                int landStart = Math.max(waterFinish, landStartTime[i]);
                int finish2 = landStart + landDuration[i];
                answer = Math.min(answer, Math.min(finish1, finish2));
            }
        }

        return answer;
    }
}
