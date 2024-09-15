package category.leetcode._2024.september;

import java.util.HashMap;
import java.util.Map;

public class September15th {

    public int findTheLongestSubstring(final String s) {
        final String vowels = "aeiou";
        int answer = 0;
        int prefix = 0;
        Map<Integer, Integer> prefixToIndex = new HashMap<>();
        prefixToIndex.put(0, -1);
        for (int i = 0; i < s.length(); ++i) {
            int index = vowels.indexOf(s.charAt(i));
            if (index != -1) {
                prefix ^= 1 << index;
            }
            prefixToIndex.putIfAbsent(prefix, i);
            answer = Math.max(answer, i - prefixToIndex.get(prefix));
        }

        return answer;
    }
}
