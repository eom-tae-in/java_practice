package category.leetcode._2026.november;

public class November22nd {

    public boolean checkString(String s) {
        boolean seenB = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'a' && seenB) {
                return false;
            }

            if (ch == 'b' && !seenB) {
                seenB = true;
            }
        }

        return true;
    }
}
