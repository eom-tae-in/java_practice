package category.leetcode._2024.august;

import java.util.Arrays;

public class August6th {

    public int minimumPushes(final String word) {
        int[] alphabets = new int[26];
        int count = 0;
        int maxSize = 8;
        for (char alphabet : word.toCharArray()) {
            alphabets[alphabet - 'a']++;
        }
        Arrays.sort(alphabets);
        for (int i = 0; i < 26; i++) {
            count += alphabets[25 - i] * (i / maxSize + 1);
        }

        return count;
    }
}
