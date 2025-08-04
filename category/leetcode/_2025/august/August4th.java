package category.leetcode._2025.august;

import java.util.HashMap;
import java.util.Map;

public class August4th {

    public int totalFruit(int[] fruits) {
        int answer = 0;
        int fruitsLength = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int left = 0, right = 0; right < fruitsLength; right++) {
            map.merge(fruits[right], 1, Integer::sum);

            while (map.size() > 2) {
                map.merge(fruits[left], -1, Integer::sum);
                map.remove(fruits[left++], 0);
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
