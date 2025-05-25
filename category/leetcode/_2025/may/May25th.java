package category.leetcode._2025.may;

public class May25th {

    public int longestPalindrome(final String[] words) {
        int answer = 0;
        int[][] count = new int[26][26];

        for (String word : words) {
            int i = word.charAt(0) - 'a';
            int j = word.charAt(1) - 'a';

            if (count[j][i] > 0) {
                answer += 4;
                count[j][i]--;
            } else {
                count[i][j]++;
            }
        }

        for (int i = 0; i < 26; ++i) {
            if (count[i][i] > 0) {
                return answer + 2;
            }
        }

        return answer;
    }
}
