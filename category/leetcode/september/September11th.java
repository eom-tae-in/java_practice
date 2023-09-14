package category.leetcode.september;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class September11th {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int key = groupSizes[i];
            List<Integer> values = map.get(key);
            if (map.containsKey(key) && values.size() < key) {
                values.add(i);
            } else {
                ArrayList<Integer> newValues = new ArrayList<>();
                newValues.add(i);
                map.put(key, newValues);
                answer.add(newValues);
            }
        }
        return answer;
    }

}
