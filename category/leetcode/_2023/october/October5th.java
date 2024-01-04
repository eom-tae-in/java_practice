package category.leetcode._2023.october;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class October5th {

    public List<Integer> majorityElement(int[] nums) {

        int count = nums.length / 3;
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (nums.length < 3) {
            for (int key : map.keySet()) {
                answer.add(key);
            }
            return answer;
        }
        for (int key : map.keySet()) {
            if (map.get(key) > count) {
                answer.add(key);
            }
        }
        return answer;
    }
}
