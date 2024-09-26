package category.leetcode._2024.september;

import java.util.TreeMap;

public class September26th {

    private final TreeMap<Integer, Integer> treeMap;

    public September26th() {
        treeMap = new TreeMap<>();
    }

    public boolean book(final int start, final int end) {
        Integer key = treeMap.lowerKey(end);

        if (key == null || treeMap.get(key) <= start) {
            treeMap.put(start, end);
            return true;
        }

        return false;
    }
}
