package category.leetcode._2025.january;

import java.util.Arrays;

public class January4th {

    public int countPalindromicSubsequence(final String s) {
        int answer = 0;
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, s.length());

        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            first[index] = Math.min(first[index], i);
            last[index] = i;
        }

        for (int i = 0; i < 26; ++i) {
            if (first[i] < last[i]) {
                answer += (int) s.substring(first[i] + 1, last[i])
                        .chars()
                        .distinct()
                        .count();
            }
        }

        return answer;
    }
}
