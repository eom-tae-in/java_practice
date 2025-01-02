package category.leetcode._2025.january;

public class January2nd {

    public int[] vowelStrings(final String[] words, final int[][] queries) {
        int[] answer = new int[queries.length];
        int[] prefix = new int[words.length + 1];

        for (int i = 0; i < words.length; ++i) {
            prefix[i + 1] += prefix[i] + (startsAndEndsWithVowel(words[i]) ? 1 : 0);
        }

        for (int i = 0; i < queries.length; ++i) {
            int left = queries[i][0];
            int right = queries[i][1];
            answer[i] = prefix[right + 1] - prefix[left];
        }

        return answer;
    }

    private boolean startsAndEndsWithVowel(final String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private boolean isVowel(final char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
