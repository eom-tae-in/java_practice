package category.leetcode.september.twenty_third;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TopDown {
    // top-down
    private final Map<String, Integer> map = new HashMap<>();

    public int longestStrChain(String[] words) {
        int answer = 0;
        Set<String> deduplicatedWords = new HashSet<>(Arrays.asList(words));
        for (String deduplicatedWord : deduplicatedWords) {
            answer = Math.max(answer, dfs(deduplicatedWord, deduplicatedWords));
        }
        return answer;
    }

    private int dfs(String word, Set<String> deduplicatedWords) {
        if (map.containsKey(word)) {
            return map.get(word);
        }
        int answer = 1;
        for (int i = 0; i < word.length(); i++) {
            String subString = word.substring(0, i) + word.substring(i + 1);
            if (deduplicatedWords.contains(subString)) {
                answer = Math.max(answer, dfs(subString, deduplicatedWords) + 1);
            }
        }
        map.put(word, answer);
        return answer;
    }
}
