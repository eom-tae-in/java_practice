package category.leetcode.december;

public class December16th {

    public boolean isAnagram(final String s, final String t) {
        char[] chars = new char[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }

        for (final char ch : chars) {
            if (chars[ch- 'a'] != 0) {
                return false;
            }
        }
        return true;
    }
}
