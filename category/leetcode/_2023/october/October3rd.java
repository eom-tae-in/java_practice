package category.leetcode._2023.october;

import java.util.HashMap;
import java.util.Map;

public class October3rd {

    public int numIdenticalPairs(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int current = map.getOrDefault(num, 0);
            answer += current;
            map.put(num, current + 1);
        }
        return answer;
    }
}
