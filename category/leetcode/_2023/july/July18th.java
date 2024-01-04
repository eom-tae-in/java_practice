package category.leetcode._2023.july;

import java.util.LinkedHashMap;
import java.util.Map;

public class July18th {
    class LRUCache {

        private final Map<Integer, Integer> map;

        public LRUCache(final int capacity) {
            map = new LinkedHashMap<>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(final int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(final int key, final int value) {
            map.put(key, value);
        }
    }
}
