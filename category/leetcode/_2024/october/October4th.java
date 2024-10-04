package category.leetcode._2024.october;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class October4th {

    public long dividePlayers(final int[] skills) {
        int n = skills.length;
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int teamSkill = Arrays.stream(skills)
                .sum() / (n / 2);

        for (int skill : skills) {
            map.merge(skill, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int skill = entry.getKey();
            int freq = entry.getValue();
            int requiredSkill = teamSkill - skill;
            if (map.getOrDefault(requiredSkill, 0) != freq) {
                return -1;
            }
            answer += (long) skill * requiredSkill * freq;
        }

        return answer / 2;
    }
}
