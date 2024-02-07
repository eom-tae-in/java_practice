package category.leetcode._2024.february;

import java.util.ArrayList;
import java.util.List;

public class February7th {

    public String frequencySort(final String s) {
        final int length = s.length();
        int[] asciiChar = new int[128];
        StringBuilder stringBuilder = new StringBuilder();
        List<Character>[] count = new List[length + 1];

        for (char c : s.toCharArray()) {
            ++asciiChar[c];
        }

        for (int i = 0; i < 128; ++i) {
            final int freq = asciiChar[i];
            if (freq > 0) {
                if (count[freq] == null) {
                    count[freq] = new ArrayList<>();
                }
                count[freq].add((char) i);
            }
        }

        for (int freq = length; freq > 0; --freq) {
            if (count[freq] != null) {
                for (char c : count[freq]) {
                    stringBuilder.append(String.valueOf(c).repeat(freq));
                }
            }
        }

        return stringBuilder.toString();
    }
}
