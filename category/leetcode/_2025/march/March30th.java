package category.leetcode._2025.march;

import java.util.ArrayList;
import java.util.List;

public class March30th {

    public List<Integer> partitionLabels(final String s) {
        int sLength = s.length();
        int[] rightIndex = new int[26];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < sLength; i++) {
            char current = s.charAt(i);
            rightIndex[current - 'a'] = i;
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < sLength; i++) {
            right = Math.max(right, rightIndex[s.charAt(i) - 'a']);

            if (i == right) {
                answer.add(right - left + 1);
                left = right + 1;
            }
        }

        return answer;
    }
}
