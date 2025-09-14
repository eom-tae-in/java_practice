package category.leetcode._2025.september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class September14th {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        List<String> answer = new ArrayList<>();
        Map<String, String> dict = new HashMap<>();

        for (String word : wordlist) {
            dict.putIfAbsent(word, word);
            dict.putIfAbsent(lowerKey(word), word);
            dict.putIfAbsent(vowelKey(word), word);
        }

        for (final String query : queries) {
            if (dict.containsKey(query)) {
                answer.add(dict.get(query));
            } else if (dict.containsKey(lowerKey(query))) {
                answer.add(dict.get(lowerKey(query)));
            } else {
                answer.add(dict.getOrDefault(vowelKey(query), ""));
            }
        }

        return answer.toArray(new String[0]);
    }

    private String lowerKey(final String word) {
        return "$" + word.toLowerCase();
    }

    private String vowelKey(final String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : word.toCharArray()) {
            stringBuilder.append(isVowel(ch) ? '*' : Character.toLowerCase(ch));
        }

        return stringBuilder.toString();
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
