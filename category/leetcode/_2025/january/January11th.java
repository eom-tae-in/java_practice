package category.leetcode._2025.january;

public class January11th {

    public boolean canConstruct(String s, int k) {
        int sLength = s.length();

        if (sLength < k) {
            return false;
        }

        if (sLength == k) {
            return true;
        }

        int[] alphabets = new int[26];

        for (char ch : s.toCharArray()) {
            alphabets[ch - 'a']++;
        }

        int oddCase = 0;

        for (int i = 0; i < 26; i++) {
            if (alphabets[i] % 2 == 1) {
                oddCase++;
            }
        }

        return oddCase <= k;
    }
}
