package category.leetcode._2025.january;

public class January8th {

    public int countPrefixSuffixPairs(final String[] words) {
        int answer = 0;
        int wordsLength = words.length;

        for (int i = 0; i < wordsLength - 1; i++) {
            for (int j = i + 1; j < wordsLength; j++) {
                if (isPrefixAndSuffix(words[j], words[i])) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean isPrefixAndSuffix(final String target, final String pattern) {
        return target.startsWith(pattern) && target.endsWith(pattern);
    }
}
