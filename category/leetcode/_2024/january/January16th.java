package category.leetcode._2024.january;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class January16th {

    private final Map<Integer, Integer> valueIndexMap;
    private final List<Integer> values;
    private final Random random;

    public January16th() {
        this.valueIndexMap = new HashMap<>();
        this.values = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(final int val) {
        if (valueIndexMap.containsKey(val)) {
            return false;
        }

        valueIndexMap.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(final int val) {
        if (!valueIndexMap.containsKey(val)) {
            return false;
        }

        final int index = valueIndexMap.get(val);
        valueIndexMap.put(last(values), index);
        valueIndexMap.remove(val);
        values.set(index, last(values));
        values.remove(values.size() - 1);
        return true;
    }

    public int getRandom() {
        final int index = random.nextInt(values.size());
        return values.get(index);
    }

    private int last(List<Integer> values) {
        return values.get(values.size() - 1);
    }
}
