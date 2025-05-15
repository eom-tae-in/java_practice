package category.leetcode._2025.may;

import java.util.ArrayList;
import java.util.List;

public class May15th {

    public List<String> getLongestSubsequence(final String[] words, final int[] groups) {
        List<String> answer = new ArrayList<>();
        int loopCount = words.length;
        int prev = -1;

        for (int i = 0; i < loopCount; i++) {
            int current = groups[i];

            if (prev != current) {
                answer.add(words[i]);
                prev = current;
            }
        }

        return answer;
    }
}
