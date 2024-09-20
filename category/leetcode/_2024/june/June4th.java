package category.leetcode._2024.june;

import java.util.Arrays;

public class June4th {

    public int longestPalindrome(final String s) {
        int answer = 0;
        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        for (int count : counts) {
            answer += count % 2 == 0 ? count : count - 1;
        }

        return hasOddCount(counts) ? answer + 1 : answer;
    }

    private boolean hasOddCount(final int[] counts) {
        return Arrays.stream(counts)
                .anyMatch(count -> count % 2 == 1);
    }
}
