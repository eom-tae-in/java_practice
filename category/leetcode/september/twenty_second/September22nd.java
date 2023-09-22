package category.leetcode.september.twenty_second;

public class September22nd {

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int index = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(index) && ++index == s.length()) {
                return true;
            }
        }
        return false;
    }
}
