package category.leetcode._2026.february;

public class February12th {

    public int longestBalanced(String s) {
        int answer = 0;
        int sLen = s.length();

        for (int i = 0; i < sLen; i++) {
            int[] count = new int[26];
            int maxFreq = 0;
            int uniq = 0;

            for (int j = i; j < sLen; j++) {
                int curr = s.charAt(j) - 'a';

                if (count[curr] == 0) {
                    uniq++;
                }

                count[curr]++;
                maxFreq = Math.max(maxFreq, count[curr]);
                int expectedLen = maxFreq * uniq;
                int actualLen = j - i + 1;

                if (expectedLen == actualLen) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }

        return answer;
    }
}
