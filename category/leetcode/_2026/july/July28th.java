package category.leetcode._2026.july;

public class July28th {

    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int oddIdx = -1;

        for (int i = 0; i < 26; i++) {
            int currCount = count[i];

            for (int len = 0; len < currCount / 2; len++) {
                stringBuilder.append((char) (i + 'a'));
            }

            if (currCount % 2 == 1) {
                oddIdx = i;
            }
        }

        StringBuilder answer = new StringBuilder(stringBuilder);

        if (oddIdx != -1) {
            stringBuilder.append((char) (oddIdx + 'a'));
        }

        answer.append(stringBuilder.reverse().toString());

        return answer.toString();
    }
}
