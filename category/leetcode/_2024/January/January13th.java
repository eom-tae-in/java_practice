package category.leetcode._2024.January;

import java.util.Arrays;

public class January13th {

    public int minSteps(final String s, final String t) {
        int[] count = new int[26];

        for (final char c : s.toCharArray()) {
            ++count[c - 'a'];
        }

        for (final char c : t.toCharArray()) {
            --count[c - 'a'];
        }

        return Arrays.stream(count)
                .map(Math::abs)
                .sum() / 2;
    }
}
