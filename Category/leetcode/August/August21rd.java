package Category.leetcode.August;

public class August21rd {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();

        for (int i = length / 2; i > 0; i--) {
            if (length % i == 0 && s.charAt(i - 1) == s.charAt(length - 1)) {
                String str = s.substring(0, i);
                int frequency = length / i;
                if (str.repeat(frequency).equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
