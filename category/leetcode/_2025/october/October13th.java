package category.leetcode._2025.october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class October13th {

    public List<String> removeAnagrams(String[] words) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < words.length; ) {
            int j = i + 1;

            while (j < words.length && isAnagram(words[i], words[j])) {
                j++;
            }

            answer.add(words[i]);
            i = j;
        }

        return answer;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char c : a.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            count[c - 'a']--;
        }

        return Arrays.stream(count)
                .allMatch(c -> c == 0);
    }
}
