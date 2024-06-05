package category.leetcode._2024.June;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class June5th {

    public List<String> commonChars(final String[] words) {
        List<String> answer = new ArrayList<>();
        int[] wordCounts = new int[26];
        Arrays.fill(wordCounts, Integer.MAX_VALUE);
        for (String word : words) {
            int[] counts = new int[26];
            for (char wordCh : word.toCharArray()) {
                counts[wordCh - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                wordCounts[i] = Math.min(wordCounts[i], counts[i]);
            }
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < wordCounts[ch - 'a']; i++) {
                answer.add(String.valueOf(ch));
            }
        }

        return answer;
    }
}
