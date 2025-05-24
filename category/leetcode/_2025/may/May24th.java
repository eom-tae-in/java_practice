package category.leetcode._2025.may;

import java.util.ArrayList;
import java.util.List;

public class May24th {

    public List<Integer> findWordsContaining(final String[] words, final char x) {
        List<Integer> answer = new ArrayList<>();
        int wordsLength = words.length;

        for (int i = 0; i < wordsLength; i++) {
            if (words[i].indexOf(x) != -1) {
                answer.add(i);
            }
        }

        return answer;
    }
}
