package category.leetcode._2024.february;

import java.util.Arrays;

public class February5th {

    public int firstUniqChar(final String s) {
        int[] alphabet = new int[26];
        s.chars()
                .forEach(ch -> alphabet[ch - 'a']++);

        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
