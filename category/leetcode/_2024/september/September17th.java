package category.leetcode._2024.september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class September17th {

    public String[] uncommonFromSentences(final String A, final String B) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        for (String word : (A + ' ' + B).split(" ")) {
            count.merge(word, 1, Integer::sum);
        }
        for (final String word : count.keySet()) {
            if (count.get(word) == 1) {
                answer.add(word);
            }
        }

        return answer.toArray(new String[0]);
    }
}
