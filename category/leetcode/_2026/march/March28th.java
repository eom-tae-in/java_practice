package category.leetcode._2026.march;

import java.util.Arrays;

public class March28th {

    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char nonLetter = (char) ('a' - 1);
        char c = nonLetter;
        char[] word = new char[n];
        Arrays.fill(word, nonLetter);

        for (int i = 0; i < n; i++) {
            if (word[i] != nonLetter) {
                continue;
            }

            c++;

            if (c > 'z') {
                return "";
            }

            for (int j = i; j < n; j++) {
                if (lcp[i][j] > 0) {
                    word[j] = c;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nextLcp = (i + 1 < n && j + 1 < n) ? lcp[i + 1][j + 1] : 0;
                int currLcp = (word[i] == word[j]) ? 1 + nextLcp : 0;

                if (lcp[i][j] != currLcp) {
                    return "";
                }
            }
        }

        return new String(word);
    }
}
