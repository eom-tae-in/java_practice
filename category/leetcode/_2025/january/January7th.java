package category.leetcode._2025.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class January7th {

    public List<String> stringMatching(final String[] words) {
        int wordsLength = words.length;
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < wordsLength - 1; i++) {
            String current = words[i];

            for (int j = i + 1; j < wordsLength; j++) {
                if (words[j].contains(current)) {
                    answer.add(current);
                    break;
                }
            }
        }

        return answer;
    }
}
