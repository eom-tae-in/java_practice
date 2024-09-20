package category.leetcode._2024.june;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class June7th {

    public String replaceWords(final List<String> dictionary, final String sentence) {
        Map<Character, PriorityQueue<String>> map = new TreeMap<>();
        for (String word : dictionary) {
            char wordFirstChar = word.charAt(0);
            map.putIfAbsent(wordFirstChar, new PriorityQueue<>(Comparator.comparing(String::length)));
            PriorityQueue<String> queue = map.get(wordFirstChar);
            queue.offer(word);
        }

        return replaceSentence(sentence, map);
    }

    private String replaceSentence(final String sentence, final Map<Character, PriorityQueue<String>> map) {
        String[] splitSentence = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : splitSentence) {
            char wordFirstChar = word.charAt(0);
            if (map.containsKey(wordFirstChar)) {
                PriorityQueue<String> queue = map.get(wordFirstChar);
                word = findWord(queue, word);
            }
            stringBuilder.append(word)
                    .append(" ");
        }

        return stringBuilder.deleteCharAt(stringBuilder.length() - 1)
                .toString();
    }

    private String findWord(final PriorityQueue<String> queue, final String word) {
        for (String s : queue) {
            if (word.startsWith(s)) {
                return s;
            }
        }

        return word;
    }
}
