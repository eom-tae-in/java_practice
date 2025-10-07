package category.leetcode._2025.october;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class October7th {

    public int[] avoidFlood(int[] rains) {
        int[] answer = new int[rains.length];
        Arrays.fill(answer, -1);
        Map<Integer, Integer> lakeIdToFullDay = new HashMap<>();
        TreeSet<Integer> emptyDays = new TreeSet<>();

        for (int i = 0; i < rains.length; ++i) {
            int lakeId = rains[i];

            if (lakeId == 0) {
                emptyDays.add(i);
                continue;
            }

            if (lakeIdToFullDay.containsKey(lakeId)) {
                int fullDay = lakeIdToFullDay.get(lakeId);
                Integer emptyDay = emptyDays.higher(fullDay);

                if (emptyDay == null) {
                    return new int[]{};
                }

                answer[emptyDay] = lakeId;
                emptyDays.remove(emptyDay);
            }

            lakeIdToFullDay.put(lakeId, i);
        }

        for (int emptyDay : emptyDays) {
            answer[emptyDay] = 1;
        }

        return answer;
    }
}
