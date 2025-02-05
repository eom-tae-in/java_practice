package category.leetcode._2025.february;

import java.util.Arrays;

public class February5th {

    public boolean areAlmostEqual(final String s1, final String s2) {
        int[] alphabets = new int[26];
        int count = 0;
        int loopCount = s1.length();

        for (int i = 0; i < loopCount; i++) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);

            if (s1Char != s2Char) {
                alphabets[s1Char - 'a']++;
                alphabets[s2Char - 'a']--;
                count++;
            }
        }

        if (count > 2) {
            return false;
        }

        return Arrays.stream(alphabets)
                .allMatch(alphabet -> alphabet == 0);
    }
}
