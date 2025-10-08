package category.leetcode._2025.october;

import java.util.Arrays;

public class October8th {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] answer = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; ++i) {
            answer[i] = potions.length - firstIndexSuccess(spells[i], potions, success);
        }

        return answer;
    }

    private int firstIndexSuccess(int spell, int[] potions, long success) {
        int left = 0;
        int right = potions.length;

        while (left < right) {
            final int m = (left + right) / 2;
            if ((long) spell * potions[m] >= success) {
                right = m;
            } else {
                left = m + 1;
            }
        }

        return left;
    }
}
