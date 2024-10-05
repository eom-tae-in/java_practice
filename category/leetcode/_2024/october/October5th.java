package category.leetcode._2024.october;

public class October5th {

    public boolean checkInclusion(final String s1, final String s2) {
        int[] count = new int[26];
        int required = s1.length();

        for (final char c : s1.toCharArray()) {
            ++count[c - 'a'];
        }

        for (int l = 0, r = 0; r < s2.length(); ++r) {
            if (--count[s2.charAt(r) - 'a'] >= 0) {
                --required;
            }
            while (required == 0) {
                if (r - l + 1 == s1.length()) {
                    return true;
                }
                if (++count[s2.charAt(l++) - 'a'] > 0) {
                    ++required;
                }
            }
        }

        return false;
    }
}
