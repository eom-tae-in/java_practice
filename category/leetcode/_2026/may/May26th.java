package category.leetcode._2026.may;

public class May26th {

    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upper[ch - 'A'] = true;
            } else {
                lower[ch - 'a'] = true;
            }
        }

        int answer = 0;

        for (int i = 0; i < 26; i++) {
            if (upper[i] && lower[i]) {
                answer++;
            }
        }

        return answer;
    }
}
