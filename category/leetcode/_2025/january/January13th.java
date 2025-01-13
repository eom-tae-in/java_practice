package category.leetcode._2025.january;

public class January13th {

    public int minimumLength(final String s) {
        int[] alphabets = new int[26];
        int answer = 0;

        for (char ch : s.toCharArray()) {
            alphabets[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabets[i] != 0) {
                answer += alphabets[i] % 2 == 0 ? 2 : 1;
            }
        }

        return answer;
    }
}
