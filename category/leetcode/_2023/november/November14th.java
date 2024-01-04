package category.leetcode._2023.november;

import java.util.Arrays;

public class November14th {

    public int countPalindromicSubsequence(String s) {
        int sum = 0;
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, s.length());

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            first[index] = Math.min(first[index], i);
            last[index] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] < last[i]) {
                sum += s.substring(first[i] + 1, last[i])
                        .chars()
                        .distinct()
                        .count();
            }
        }

        return sum;
    }
}
