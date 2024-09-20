package category.leetcode._2024.july;

import java.util.Map;
import java.util.TreeMap;

public class July22nd {

    public String[] sortPeople(final String[] names, final int[] heights) {
        Map<Integer, String> map = new TreeMap<>((a, b) -> b - a);
        int n = names.length;
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }
        int index = 0;
        for (String value : map.values()) {
            names[index++] = value;
        }

        return names;
    }
}
