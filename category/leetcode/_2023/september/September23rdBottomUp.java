package category.leetcode._2023.september;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class September23rdBottomUp {
    public int longestStrChain(String[] words) {
        int answer = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> map = new HashMap<>();
        for (String deduplicatedWord : words) {
            if (map.containsKey(deduplicatedWord)) {
                continue;
            }
            int length = 0;
            for (int i = 0; i < deduplicatedWord.length(); i++) {
                String subString = deduplicatedWord.substring(0, i) + deduplicatedWord.substring(i + 1);
                length = Math.max(length, map.getOrDefault(subString, 0) + 1);
            }
            map.put(deduplicatedWord, length);
            answer = Math.max(answer, length);
        }
        return answer;
    }
}
