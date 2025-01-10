package category.leetcode._2025.january;

import java.util.ArrayList;
import java.util.List;

public class January10th {

    public List<String> wordSubsets(final String[] words1, final String[] words2) {
        int[] subsetAlphabets = new int[26];
        List<String> answer = new ArrayList<>();

        for (String word2 : words2) {
            int[] currentSubsetAlphabets = calculateAlphabets(word2);

            for (int i = 0; i < 26; i++) {
                subsetAlphabets[i] = Math.max(subsetAlphabets[i], currentSubsetAlphabets[i]);
            }
        }

        for (String word1 : words1) {
            int[] currentSubsetAlphabets = calculateAlphabets(word1);

            if (isSubset(currentSubsetAlphabets, subsetAlphabets)) {
                answer.add(word1);
            }
        }

        return answer;
    }

    private int[] calculateAlphabets(final String word) {
        int[] alphabets = new int[26];

        for (char ch : word.toCharArray()) {
            alphabets[ch - 'a']++;
        }

        return alphabets;
    }

    private boolean isSubset(final int[] currentAlphabets, final int[] alphabets) {
        for (int i = 0; i < 26; i++) {
            if (currentAlphabets[i] < alphabets[i]) {
                return false;
            }
        }

        return true;
    }
}
