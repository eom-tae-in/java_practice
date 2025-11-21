package category.leetcode._2025.november;

import java.util.Arrays;

public class November21st {

    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, n);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int curr = s.charAt(i) - 'a';
            first[curr] = Math.min(i, first[curr]);
            last[curr] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] != n && first[i] != last[i]) {
                answer += countDistinctChar(first[i], last[i], s);
            }
        }

        return answer;
    }

    private int countDistinctChar(int start, int end, String s) {
        int count = 0;
        boolean[] visited = new boolean[26];

        for (int i = start + 1; i < end; i++) {
            int curr = s.charAt(i) - 'a';

            if (!visited[curr]) {
                visited[curr] = true;
                count++;
            }
        }

        return count;
    }
}
