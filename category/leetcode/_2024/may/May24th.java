package category.leetcode._2024.may;

import java.util.ArrayList;
import java.util.List;

public class May24th {

    private int maxValue = Integer.MIN_VALUE;

    public int maxScoreWords(final String[] words, final char[] letters, final int[] score) {
        List<String> subsetWords = new ArrayList<>();
        dfs(0, subsetWords, words, letters, score);

        return maxValue;
    }

    private void dfs(final int index, final List<String> subsetWords, final String[] words, final char[] letters,
                     final int[] score) {
        maxValue = Math.max(maxValue, calculateSubsetScore(subsetWords, letters, score));

        for (int i = index; i < words.length; i++) {
            subsetWords.add(words[i]);
            dfs(i + 1, subsetWords, words, letters, score);
            subsetWords.remove(subsetWords.size() - 1);
        }
    }

    private int calculateSubsetScore(final List<String> subsetWords, final char[] letters, final int[] score) {
        int subsetScore = 0;
        char[] chars = new char[26];

        for (char letter : letters) {
            chars[letter - 'a']++;
        }

        for (String subsetWord : subsetWords) {
            for (char wordLetter : subsetWord.toCharArray()) {
                if (chars[wordLetter - 'a']-- < 1) {
                    return 0;
                }
                subsetScore += score[wordLetter - 'a'];
            }
        }

        return subsetScore;
    }
}
