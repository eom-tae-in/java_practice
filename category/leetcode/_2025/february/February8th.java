package category.leetcode._2025.february;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class February8th {

    private final Map<Integer, TreeSet<Integer>> numberToIndices = new HashMap<>();
    private final Map<Integer, Integer> indexToNumbers = new HashMap<>();

    public void change(final int index, final int number) {
        if (indexToNumbers.containsKey(index)) {
            int originalNumber = indexToNumbers.get(index);
            numberToIndices.get(originalNumber).remove(index);

            if (numberToIndices.get(originalNumber).isEmpty()) {
                numberToIndices.remove(originalNumber);
            }
        }

        indexToNumbers.put(index, number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }

    public int find(final int number) {
        if (numberToIndices.containsKey(number)) {
            return numberToIndices.get(number).first();
        }

        return -1;
    }
}
