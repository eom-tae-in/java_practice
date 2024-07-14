package category.leetcode._2024.July;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class July14th {

    private int index = 0;

    public String countOfAtoms(final String formula) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry<String, Integer> entry : makeChemicalFormula(formula).entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            stringBuilder.append(key);
            if (value != 1) {
                stringBuilder.append(value);
            }
        }

        return stringBuilder.toString();
    }

    private Map<String, Integer> makeChemicalFormula(final String formula) {
        Map<String, Integer> map = new TreeMap<>();
        while (index < formula.length()) {
            char current = formula.charAt(index);
            if (current == '(') {
                index++;
                for (Entry<String, Integer> entry : makeChemicalFormula(formula).entrySet()) {
                    String key = entry.getKey();
                    int value = entry.getValue();
                    map.merge(key, value, Integer::sum);
                }
            } else if (current == ')') {
                index++;
                int num = getNum(formula);
                for (String key : map.keySet()) {
                    int value = map.get(key);
                    map.put(key, value * num);
                }
                return map;
            } else {
                String atom = getAtom(formula);
                int num = getNum(formula);
                map.merge(atom, num, Integer::sum);
            }
        }

        return map;
    }

    private String getAtom(final String formula) {
        int startIndex = index++;
        int n = formula.length();
        while (index < n && Character.isLowerCase(formula.charAt(index))) {
            index++;
        }

        return formula.substring(startIndex, index);
    }

    private int getNum(final String formula) {
        int startIndex = index;
        int n = formula.length();
        while (index < n && Character.isDigit(formula.charAt(index))) {
            index++;
        }
        String numString = formula.substring(startIndex, index);

        return numString.isEmpty() ? 1 : Integer.parseInt(numString);
    }
}
