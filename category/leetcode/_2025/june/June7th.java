package category.leetcode._2025.june;

import java.util.ArrayList;
import java.util.List;

public class June7th {

    public String clearStars(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        List<Integer>[] buckets = new List[26];

        for (int i = 0; i < 26; ++i) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '*') {
                stringBuilder.setCharAt(i, ' ');
                int j = 0;

                while (buckets[j].isEmpty()) {
                    ++j;
                }

                stringBuilder.setCharAt(buckets[j].remove(buckets[j].size() - 1), ' ');
            } else {
                buckets[s.charAt(i) - 'a'].add(i);
            }
        }

        return stringBuilder.toString().replace(" ", "");
    }
}
